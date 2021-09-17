package com.denis.model;

import com.denis.model.workers.Manager;
import com.denis.model.workers.OtherEmployee;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Manager> managerList = new ArrayList<>();
    private List<OtherEmployee> otherEmployeeList = new ArrayList<>();
    private boolean isCompanyFond;

    public Model(List<Manager> managerList, List<OtherEmployee> otherEmployeeList) {
        this.managerList = managerList;
        this.otherEmployeeList = otherEmployeeList;
    }

    public boolean isCompanyFond() {
        return isCompanyFond;
    }

    public void setCompanyFond(boolean companyFond) {
        isCompanyFond = companyFond;
    }
}
