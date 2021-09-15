package com.denis.model;

import com.denis.model.workers.Employee;
import com.denis.model.workers.Manager;

import java.util.*;

public class Department {

    private String name;
    private List<Employee> listEmployee = new ArrayList<>();
    private Fund fund;
    private Manager manager;

    public Department(String name, Fund fund, Manager manager) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(fund);
        Objects.requireNonNull(manager);
        this.fund = fund;
        this.name = name;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getListEmployee() {
        return manager.getEmployeeList();
    }

    public void setListEmployee(List<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    public void addEmployee(Employee employee) {
        manager.addEmployee(employee);
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

        Department department = (Department) o;

        return name.equals(department.name)
                && manager.equals(department.manager)
                && fund.equals(department.fund);
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        int number = 31;
        int result = ((name.hashCode() * number + manager.hashCode()) * number + fund.hashCode()) * number;
        return result;
    }
}
