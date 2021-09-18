package com.denis.model;

import com.denis.model.workers.Employee;
import com.denis.model.workers.Manager;

import java.math.BigDecimal;
import java.util.*;

public abstract class Department<T> {

    private String name;
    private Fund fund;

    public Department(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

   abstract BigDecimal getRate();

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void addEmployee(T employee);

    public abstract List<T> getEmployeeList();

}
