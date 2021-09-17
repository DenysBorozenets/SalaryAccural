package com.denis.model.workers;

import com.denis.model.exception.NotCorrectSalaryAmount;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class OtherEmployee extends Employee {

    private String position;
    private String description;

    public OtherEmployee(String name, String position,Date birthday, Date startWork) throws NotCorrectSalaryAmount {
        super(name, birthday, startWork);
        this.position = position;
    }
    public OtherEmployee(String name, Date birthday, Date startWork, BigDecimal salary, String position) throws NotCorrectSalaryAmount {
        super(name, birthday, startWork, salary);
        Objects.requireNonNull(position);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o))
            return false;
        if (!(o instanceof OtherEmployee))
            return false;

        OtherEmployee otherEmployee = (OtherEmployee) o;

        return this.position.equals(otherEmployee.position) && this.description.equals(otherEmployee.description);
    }

    @Override
    public int hashCode() {
        int number = 31;
        int result = position.hashCode() * number
                + description.hashCode() * number;
        return result;
    }
}
