package com.denis.model;

import java.util.HashSet;
import java.util.Set;

public class Department {

    private String name;
    //we use HashSet so that the same worker is not added in the future
    private Set<Employee> listEmployee = new HashSet<>();

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(Set<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }
}
