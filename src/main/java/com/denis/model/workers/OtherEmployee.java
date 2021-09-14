package com.denis.model.workers;

import java.util.Date;

public class OtherEmployee extends Employee{
    private String position;
    private String description;

    public OtherEmployee(String name, Date birthday, Date startWork, String position, String description) {
        super(name, birthday, startWork);
        this.position = position;
        this.description = description;
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
        if (!super.equals(o) || !(o instanceof OtherEmployee))
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
