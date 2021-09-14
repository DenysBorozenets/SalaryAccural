package com.denis.model;

import com.denis.model.workers.Employee;

import java.util.*;

public class Department {

    private String name;
    private List<Employee> listEmployee = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(List<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    public void addEmployee(Employee employee) {
        listEmployee.add(employee);
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
        //if (!(o instanceof Employee)) return false;

        Department department = (Department) o;
        return name.equals(department.name) && listEmployee.equals(department.listEmployee);
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        int number = 31;
        int result = name.hashCode() * number
                + listEmployee.hashCode();
        return result;
    }
}
