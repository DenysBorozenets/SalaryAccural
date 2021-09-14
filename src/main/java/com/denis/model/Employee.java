package com.denis.model;

import java.util.Date;

public class Employee {
    private String name;
    private Date birthday;
    private Date startWork;

    public Employee(String name, Date birthday, Date startWork) {
        this.name = name;
        this.birthday = birthday;
        this.startWork = startWork;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getStartWork() {
        return startWork;
    }

    public void setStartWork(Date startWork) {
        this.startWork = startWork;
    }

    /**
     * from code example
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        //if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;
        return name.equals(employee.name) && birthday.equals(employee.birthday) && startWork.equals(employee.startWork);
    }

    /**
     *
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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", startWork=" + startWork +
                '}';
    }
}
