package com.denis.model;

import com.denis.model.workers.OtherEmployee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OthersDepartment extends Department<OtherEmployee> {
    private List<OtherEmployee> employeeList = new ArrayList<>();

    public OthersDepartment(String name) {
        super(name);
    }

    @Override
    public void addEmployee(OtherEmployee employee) {
        employeeList.add(employee);
    }

    @Override
    public List<OtherEmployee> getEmployeeList() {
        return employeeList;
    }

    @Override
    BigDecimal getRate() {
        BigDecimal result = new BigDecimal("0");
        for (OtherEmployee empTmp : employeeList) {
            result = result.add(empTmp.getSalary());
        }
        return result;
    }
}
