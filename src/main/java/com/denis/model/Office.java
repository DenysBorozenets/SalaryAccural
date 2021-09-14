package com.denis.model;

import com.denis.model.workers.Employee;

import java.util.ArrayList;
import java.util.List;

public class Office {

    private String name;
    private Employee headOfOffice;
    private List<Department> departList = new ArrayList<>();

    public Office(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addDepartment(Department department) {
        departList.add(department);
    }

    public List<Department> getDepartList() {
        return departList;
    }

    public Employee getHeadOfOffice() {
        return headOfOffice;
    }

    public void setHeadOfOffice(Employee headOfOffice) {
        this.headOfOffice = headOfOffice;
    }
}
