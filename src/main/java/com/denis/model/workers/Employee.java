package com.denis.model.workers;

import java.util.Date;

public class Employee {
    final private String name;
    final private Date birthday;
    final private Date startWork;

    public Employee(String name, Date birthday, Date startWork) {
        this.name = name;
        this.birthday = new Date(birthday.getTime());
        this.startWork = new Date(startWork.getTime());
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

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", startWork=" + startWork +
                '}';
    }
}
