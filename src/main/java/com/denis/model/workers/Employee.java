package com.denis.model.workers;

import com.denis.model.Balance;
import com.denis.model.exception.NotCorrectSalaryAmount;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Employee {

    private String name;
    private Date birthday;
    private Date startWork;
    private BigDecimal salary;

    /**
     * @param name
     * @param birthday
     * @param startWork
     */
    public Employee(String name, Date birthday, Date startWork) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(birthday);
        Objects.requireNonNull(startWork);
        this.name = name;
        this.birthday = new Date(birthday.getTime());
        this.startWork = new Date(startWork.getTime());
        this.salary = Balance.MIN_SALARY;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return new Date(birthday.getTime());
    }

    public Date getStartWork() {
        return new Date(startWork.getTime());
    }

    public void setSalary(BigDecimal salary) throws NotCorrectSalaryAmount {
        Objects.requireNonNull(salary);
        compareSalary(salary);
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void compareSalary(BigDecimal salary) throws NotCorrectSalaryAmount {
        if (salary.compareTo(Balance.MIN_SALARY) < 0) {
            throw new NotCorrectSalaryAmount(salary, Balance.MIN_SALARY);
        }
    }

    /**
     * from code example
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!(o instanceof Employee))
            return false;

        Employee employee = (Employee) o;

        return name.equals(employee.name)
                && birthday.equals(employee.birthday)
                && startWork.equals(employee.startWork);
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        int number = 31;
        int result = name.hashCode() * number
                + birthday.hashCode() * number
                + startWork.hashCode();
        return result;
    }

}
