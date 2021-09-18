import com.denis.model.Department;
import com.denis.model.Fund;
import com.denis.model.exception.NotCorrectSalaryAmount;
import com.denis.model.workers.Employee;
import com.denis.model.workers.Manager;
import com.denis.model.workers.OtherEmployee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class DepartmentTest {
    Department dep1;
    Department dep2;


    @Before
    public void test() throws NotCorrectSalaryAmount {
//        Employee first = new Employee("Denis", new Date(1234566789), new Date(1234567789));
//        Employee second = new Employee("Vika", new Date(1234567889), new Date(1234567899));
//        Employee third = new Employee("Denis", new Date(1234566789), new Date(1234567789));
//        Employee fourth = new Employee("Vika", new Date(1234567889), new Date(1234567899));

//        Employee first = new OtherEmployee("Denis", new Date(1234566789), new Date(1234567789), "Direct", "Else");
//        Employee second = new OtherEmployee("Vika", new Date(1234567889), new Date(1234567899), "Dev", "Some");
//        Employee third = new OtherEmployee("Denis", new Date(1234566789), new Date(1234567789), "Direct", "Else");
//        Employee fourth = new OtherEmployee("Vika", new Date(1234567889), new Date(1234567899), "Dev", "Some");

        Employee denis1 = new OtherEmployee("Denis","Director", new Date(1284237214), new Date(1599856414));
        Employee vika1 = new OtherEmployee("Vika","Developer", new Date(1315773214), new Date(1442003614));
        Employee denis2 = new OtherEmployee("Denis","Director", new Date(1284237214), new Date(1599856414));
        Employee vika2 = new OtherEmployee("Vika","Developer", new Date(1315773214), new Date(1442003614));


        dep1 = new Department("dep", new Manager("Vova", new Date(1000), new Date(2000)));
        dep1.setFund(new Fund(Fund.Balance.BALANCED));
        dep1.addEmployee(denis1);
        dep1.addEmployee(vika1);

        dep2 = new Department("dep", new Manager("Vova", new Date(1000), new Date(2000)));
        dep2.setFund(new Fund(Fund.Balance.BALANCED));
        dep2.addEmployee(denis2);
        dep2.addEmployee(vika2);
    }

    @Test
    public void equalTest() {
        Assert.assertTrue(dep1.equals(dep1));
        Assert.assertTrue(dep1.equals(dep2));
        Assert.assertTrue(dep2.equals(dep1));
    }

    @Test
    public void hashTest() {
        Assert.assertEquals(dep1.hashCode(), dep1.hashCode());
        Assert.assertEquals(dep1.hashCode(), dep2.hashCode());
        Assert.assertEquals(dep2.hashCode(), dep1.hashCode());
    }
}
