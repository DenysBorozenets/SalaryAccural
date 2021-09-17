package com.denis.model.workers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager extends Employee {

    private List<Employee> employeeList = new ArrayList<>();

    public Manager(String name, Date birthday, Date startWork) {
        super(name, birthday, startWork);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o) ||  !(o instanceof Manager))
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
