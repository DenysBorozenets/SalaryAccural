package com.denis.model;

import com.denis.model.pay.PayForOne;
import com.denis.model.pay.Payroll;
import com.denis.model.workers.Employee;
import com.denis.model.workers.Manager;
import com.denis.model.workers.OtherEmployee;
import com.denis.view.View;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Model {

    private List<Department> departmentList = new ArrayList<>();
    private List<OtherEmployee> otherEmployeeList = new ArrayList<>();
    private Fund fund;
    private Fund.Balance fundTypeForOthers = Fund.Balance.BALANCED;
    private MathContext mc = new MathContext(20, RoundingMode.FLOOR);

    public Model(List<Department> departmentList, List<OtherEmployee> otherEmployeeList) {
        this.departmentList = departmentList;
        this.otherEmployeeList = otherEmployeeList;
    }

    public Payroll calculatePayroll(Date date){
        int calcMonth = date.getMonth();
        Payroll result = new Payroll();
        BigDecimal minFund = this.getMinFund();
        BigDecimal remainder = fund.getSum().subtract(minFund);
        BigDecimal othersSalary = new BigDecimal("0");

        if (fund.getBalance().equals(Fund.Balance.BALANCED)){
            int amountParts = departmentList.size()+1;
            BigDecimal departmentSalary = remainder.divide(new BigDecimal(amountParts),mc);
            for (Department department: departmentList){
                department.getFund().setSum(departmentSalary);
            }
            othersSalary = departmentSalary;
        }else if (fund.getBalance().equals(Fund.Balance.UNBALANCED)){
            BigDecimal sum = new BigDecimal("0");
            for (Department department: departmentList){
                BigDecimal minSalaryDep = department.getSalary();
                BigDecimal depPart = minSalaryDep.divide(minFund,mc);
                BigDecimal depSalary = depPart.multiply(remainder);
                department.getFund().setSum(depSalary);
                sum = sum.add(depSalary);
            }
            othersSalary = remainder.subtract(sum);
        }

        for (Department depTmp: departmentList){
            result.personList.addAll(calcDepartment(depTmp));
        }
        result.personList.addAll(calcOthers(otherEmployeeList,othersSalary,fundTypeForOthers));

        return result;
    }

    private List<PayForOne> calcOthers(List<OtherEmployee> othersEmployee
            , BigDecimal salary
            , Fund.Balance type){
        List<PayForOne> personList = new ArrayList<>();

        if (type.equals(Fund.Balance.BALANCED)){
            int amountParts = othersEmployee.size();
            BigDecimal employeeSalary = salary.divide(new BigDecimal(amountParts),mc);
            for (Employee employee: othersEmployee){
                PayForOne payForOnePerson = new PayForOne(employee, employeeSalary.add(employee.getSalary()));
                payForOnePerson.setDepartmentName(View.OTHER_NAME);
                payForOnePerson.setPremium(employeeSalary);
                personList.add(payForOnePerson);
            }
        }else if (type.equals(Fund.Balance.UNBALANCED)){
            BigDecimal minSalaryDep = new BigDecimal("0");
            for (Employee employee: othersEmployee){
                minSalaryDep = minSalaryDep.add(employee.getSalary());
            }
            for (Employee employee: othersEmployee){
                BigDecimal empPart = employee.getSalary().divide(minSalaryDep,mc); BigDecimal empSalary = empPart.multiply(salary);
                PayForOne payForOnePerson = new PayForOne(employee, empSalary.add(employee.getSalary()));
                payForOnePerson.setDepartmentName(View.OTHER_NAME);
                payForOnePerson.setPremium(empSalary);
                personList.add(payForOnePerson);
            }
        }

        return personList;
    }

    private List<PayForOne> calcDepartment(Department department){
        List<PayForOne> personList = new ArrayList<>();
        BigDecimal amount = department.getFund().getSum();

        if (department.getFund().getBalance().equals(Fund.Balance.BALANCED)){
            int amountParts = department.getListEmployee().size()+1;
            BigDecimal employeeSalary = amount.divide(new BigDecimal(amountParts),mc);
            PayForOne payForOneManager = new PayForOne(department.getManager(),
                    employeeSalary.add(department.getManager().getSalary()));
            payForOneManager.setDepartmentName(department.getName());
            payForOneManager.setPremium(employeeSalary);
            personList.add(payForOneManager);
            for (Employee employee: department.getListEmployee()){
                PayForOne payForOnePerson = new PayForOne(employee, employeeSalary.add(employee.getSalary()));
                payForOnePerson.setDepartmentName(department.getName());
                payForOnePerson.setPremium(employeeSalary);
                personList.add(payForOnePerson);
            }
        }else if (department.getFund().getBalance().equals(Fund.Balance.UNBALANCED)){
            BigDecimal minSalaryDep = department.getSalary();

            BigDecimal manPart = department.getManager().getSalary().divide(minSalaryDep,mc);
            BigDecimal manSalary = manPart.multiply(amount);
            PayForOne payForOneManager = new PayForOne(department.getManager(),
                    manSalary.add(department.getManager().getSalary()));
            payForOneManager.setDepartmentName(department.getName());
            payForOneManager.setPremium(manSalary);
            personList.add(payForOneManager);

            for (Employee employee: department.getListEmployee()){
                BigDecimal empPart = employee.getSalary().divide(minSalaryDep,mc);
                BigDecimal empSalary = empPart.multiply(amount);
                PayForOne payForOnePerson = new PayForOne(employee, empSalary.add(employee.getSalary()));
                payForOnePerson.setDepartmentName(department.getName());
                payForOnePerson.setPremium(empSalary);
                personList.add(payForOnePerson);
            }
        }

        return personList;
    }

    public BigDecimal getMinFund(){
        BigDecimal result = new BigDecimal("0");
        for (Department depTmp: departmentList){
            result = result.add(depTmp.getManager().getSalary());
            for (Employee empTmp: depTmp.getListEmployee()){
                result = result.add(empTmp.getSalary());
            }
        }

        for (OtherEmployee otherTmp: otherEmployeeList){
            result = result.add(otherTmp.getSalary());
        }

        return result;
    }


    public BigDecimal getMinSalary(Date date){
        BigDecimal result = new BigDecimal("0");
        for (ManagerDepartment depTmp: departmentList){
            result = result.add(depTmp.getMinSalary(date));
        }
        result = result.add(otherEmployeeList.getMinSalary(date));

        return result;
    }

    public Fund.Balance getFundTypeForOthers() {
        return fundTypeForOthers;
    }

    public void setFundTypeForOthers(Fund.Balance fundTypeForOthers) {
        this.fundTypeForOthers = fundTypeForOthers;
    }

    public void addOtherEmployee(OtherEmployee otherEmployee) {
        otherEmployeeList.add(otherEmployee);
    }

    public void addDepartment(Department department) {
        departmentList.add(department);
    }

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public List<OtherEmployee> getOtherEmployeeList() {
        return otherEmployeeList;
    }
}
