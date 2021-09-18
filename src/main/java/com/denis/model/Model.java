package com.denis.model;

import com.denis.model.workers.Manager;
import com.denis.model.workers.OtherEmployee;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Department> departmentList = new ArrayList<>();
    private List<OtherEmployee> otherEmployeeList = new ArrayList<>();
    private Fund fund;
    private Fund.Balance fundTypeForOthers = Fund.Balance.BALANCED;

    public Model(List<Department> departmentList, List<OtherEmployee> otherEmployeeList) {
        this.departmentList = departmentList;
        this.otherEmployeeList = otherEmployeeList;
    }

    public Fund.Balance getFundTypeForOthers() {
        return fundTypeForOthers;
    }

    public void setFundTypeForOthers(Fund.Balance fundTypeForOthers) {
        this.fundTypeForOthers = fundTypeForOthers;
    }

    public void addOtherEmployee(OtherEmployee otherEmployee) {
        otherEmployeeList.add(otherEmployee);
    }

    public void addDepartment(Department department) {
        departmentList.add(department);
    }

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public List<OtherEmployee> getOtherEmployeeList() {
        return otherEmployeeList;
    }
}
