package com.denis.model.exception;

import java.math.BigDecimal;

public class NotCorrectSalaryAmount extends Exception {

    private BigDecimal salary;
    private BigDecimal compareMinSalary;

    public NotCorrectSalaryAmount(BigDecimal salary, BigDecimal compareMinSalary) {
        this.salary = new BigDecimal(String.valueOf(salary));
        this.compareMinSalary = new BigDecimal(String.valueOf(compareMinSalary));
    }

    public BigDecimal getSalary() {
        return new BigDecimal(String.valueOf(salary));
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCompareMinSalary() {
        return compareMinSalary;
    }

    public void setCompareMinSalary(BigDecimal compareMinSalary) {
        this.compareMinSalary = compareMinSalary;
    }

    @Override
    public String toString() {
        return "NotCorrectSalaryAmount{" +
                "salary=" + salary + "less then" +
                " compareMinSalary=" + compareMinSalary +
                '}';
    }
}
