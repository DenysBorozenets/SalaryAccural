package com.denis.model.workers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager extends Employee {

    List<Employee> employeeList = new ArrayList<>();

    public Manager(String name, Date birthday, Date startWork) {
        super(name, birthday, startWork);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Manager manager = (Manager) o;
        return this.employeeList.equals(manager.employeeList);
    }

    @Override
    public int hashCode() {
        int number = 31;
        return employeeList.hashCode() * number;
    }
}
