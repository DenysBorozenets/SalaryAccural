package com.denis.model;

import com.denis.model.workers.Employee;
import com.denis.model.workers.Manager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ManagerDepartment extends Department<Employee>{

    private Manager manager;

    public ManagerDepartment(String name, Manager manager) {
        super(name);
        this.manager = manager;
    }

    public void addEmployee(Employee employee){
        manager.addEmployee(employee);
    }

    public List<Employee> getEmployeeList() {
        List<Employee> result = new ArrayList<>();
        result.add(getManager());
        result.addAll(getManager().getEmployeeList());
        return result;
    }

    public Manager getManager() {
        return manager;
    }

    public BigDecimal getRate(){
        BigDecimal result = new BigDecimal("0");
        result = result.add(manager.getSalary());
        for (Employee employeeTmp: manager.getEmployeeList()){
            result = result.add(employeeTmp.getSalary());
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerDepartment that = (ManagerDepartment) o;
        return name.equals(that.name)
                && manager.equals(that.manager)
                && fund.equals(that.fund);
    }

    @Override
    public int hashCode() {
        int simpleNumeric = 31;
        return ((name.hashCode()
                * simpleNumeric
                + manager.hashCode())
                * simpleNumeric
                + fund.hashCode())
                * simpleNumeric;
    }
}
