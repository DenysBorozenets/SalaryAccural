package com.denis.model.database;

import com.denis.model.Department;
import com.denis.model.exception.NotCorrectSalaryAmount;
import com.denis.model.workers.Employee;
import com.denis.model.workers.Manager;
import com.denis.model.workers.OtherEmployee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBase {

    public static List<Department> initDepart() throws NotCorrectSalaryAmount {
        List<Department> list = new ArrayList<>();

        Manager manager1 = new Manager("КОВАЛЕНКО", new Date(811081984), new Date(1536928415), new BigDecimal("8000"));
        manager1.addEmployee(new Employee("БОНДАР", new Date(937312384), new Date(1630499615),new BigDecimal("2000")));
        manager1.addEmployee(new Employee("САВЧЕНКО", new Date(916317184), new Date(1630499615),new BigDecimal("2500")));
        manager1.addEmployee(new Employee("ГАВРИЛЮК", new Date(918995584), new Date(1630499615),new BigDecimal("1500")));
        manager1.addEmployee(new Employee("БОНДАР", new Date(921414784), new Date(1630499615),new BigDecimal("1100")));
        manager1.addEmployee(new Employee("КУШНІР", new Date(924093184), new Date(1630499615),new BigDecimal("2600")));
        manager1.addEmployee(new Employee("КОЛОМІЄЦЬ", new Date(926685184), new Date(1630499615),new BigDecimal("3200")));
        manager1.addEmployee(new Employee("ПАНЧЕНКО", new Date(929363584), new Date(1630499615),new BigDecimal("2500")));

        list.add(new Department("Payout", manager1));

        Manager manager2 = new Manager("КОВАЛЕНКО", new Date(811081984), new Date(1536928415),new BigDecimal("12000"));
        manager2.addEmployee(new Employee("БОНДАР", new Date(937312384), new Date(1630499615),new BigDecimal("2000")));
        manager2.addEmployee(new Employee("САВЧЕНКО", new Date(916317184), new Date(1630499615),new BigDecimal("2500")));
        manager2.addEmployee(new Employee("ГАВРИЛЮК", new Date(918995584), new Date(1630499615),new BigDecimal("1500")));
        manager2.addEmployee(new Employee("БОНДАР", new Date(921414784), new Date(1630499615),new BigDecimal("1100")));
        manager2.addEmployee(new Employee("КУШНІР", new Date(924093184), new Date(1630499615),new BigDecimal("2600")));
        manager2.addEmployee(new Employee("КОЛОМІЄЦЬ", new Date(926685184), new Date(1630499615),new BigDecimal("3200")));
        manager2.addEmployee(new Employee("ПАНЧЕНКО", new Date(929363584), new Date(1630499615),new BigDecimal("2500")));

        list.add(new Department("Economy", manager2));

        Manager manager3 = new Manager("КОВАЛЕНКО", new Date(811081984), new Date(1536928415),new BigDecimal("22000"));
        manager3.addEmployee(new Employee("БОНДАР", new Date(937312384), new Date(1630499615),new BigDecimal("4200")));
        manager3.addEmployee(new Employee("САВЧЕНКО", new Date(916317184), new Date(1630499615),new BigDecimal("5300")));
        manager3.addEmployee(new Employee("ГАВРИЛЮК", new Date(918995584), new Date(1630499615),new BigDecimal("8000")));
        manager3.addEmployee(new Employee("БОНДАР", new Date(921414784), new Date(1630499615),new BigDecimal("1500")));
        manager3.addEmployee(new Employee("КУШНІР", new Date(924093184), new Date(1630499615),new BigDecimal("3200")));
        manager3.addEmployee(new Employee("КОЛОМІЄЦЬ", new Date(926685184), new Date(1630499615),new BigDecimal("2540")));
        manager3.addEmployee(new Employee("ПАНЧЕНКО", new Date(929363584), new Date(1630499615),new BigDecimal("3620")));

        list.add(new Department("Development", manager3));

        return list;
    }

    public static List<OtherEmployee> initOther() throws NotCorrectSalaryAmount {
        List<OtherEmployee> list = new ArrayList<>();

        list.add(new OtherEmployee("БОНДАРЧУК",new Date(500819584), new Date(1472733215),new BigDecimal("45000"),"Director"));
        list.add(new OtherEmployee("ДЕРКАЧ",new Date(503411584), new Date(1472733215),new BigDecimal("3500"),"Consultant"));
        list.add(new OtherEmployee("СЕРГІЄНКО",new Date(495549184), new Date(1472733215),new BigDecimal("2300"),"Secretary"));
        list.add(new OtherEmployee("БОДНАР",new Date(832077184), new Date(1472733215),new BigDecimal("8600"),"HR"));

        return list;
    }
}
