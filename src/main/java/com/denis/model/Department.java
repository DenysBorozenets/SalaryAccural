package com.denis.model;

import java.util.HashSet;
import java.util.Objects;
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

        Department department = (Department) o;
        return name.equals(department.name) && Objects.equals(listEmployee, department.listEmployee);
    }

    /**
     *
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
