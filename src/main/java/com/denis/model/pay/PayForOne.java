package com.denis.model.pay;

import com.denis.model.workers.Employee;

import java.math.BigDecimal;

public class PayForOne {
    private Employee employee;
    private String departmentName;
    private BigDecimal salary;
    private BigDecimal premium;

    public PayForOne(Employee employee, BigDecimal salary) {
        this.employee = employee;
        this.salary = salary.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
