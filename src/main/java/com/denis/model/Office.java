package com.denis.model;

import com.denis.model.workers.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Office {

    private String name;
    private Employee headOfOffice;
    private List<Department> departList = new ArrayList<>();
    private Fund fund;
    private boolean isCompanyFund;

    public Office(String name, Fund fund) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(fund);
        this.name = name;
        this.fund = fund;

    }

    public boolean isCompanyFund() {
        return isCompanyFund;
    }

    public void setCompanyFund(boolean companyFund) {
        isCompanyFund = companyFund;
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

    /**
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
        Office office = (Office) o;
        return this.name.equals(office.name)
                && headOfOffice.equals(office.headOfOffice)
                && departList.equals(office.departList)
                && fund.equals(office.fund);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int number = 31;
        int result = ((name.hashCode() * number
                + headOfOffice.hashCode()) * number
                + fund.hashCode()) * number;
        return result;
    }
}
