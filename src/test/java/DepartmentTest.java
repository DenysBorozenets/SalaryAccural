import com.denis.model.Department;
import com.denis.model.Fund;
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
    public void test() {
//        Employee first = new Employee("Denis", new Date(1234566789), new Date(1234567789));
//        Employee second = new Employee("Vika", new Date(1234567889), new Date(1234567899));
//        Employee third = new Employee("Denis", new Date(1234566789), new Date(1234567789));
//        Employee fourth = new Employee("Vika", new Date(1234567889), new Date(1234567899));

        Employee first = new OtherEmployee("Denis", new Date(1234566789), new Date(1234567789), "Direct", "Else");
        Employee second = new OtherEmployee("Vika", new Date(1234567889), new Date(1234567899), "Dev", "Some");
        Employee third = new OtherEmployee("Denis", new Date(1234566789), new Date(1234567789), "Direct", "Else");
        Employee fourth = new OtherEmployee("Vika", new Date(1234567889), new Date(1234567899), "Dev", "Some");


        dep1 = new Department("dep", new Fund(Fund.Balance.BALANCED), new Manager("Vova", new Date(1000), new Date(2000)));
        dep1.addEmployee(first);
        dep1.addEmployee(second);

        dep2 = new Department("dep", new Fund(Fund.Balance.BALANCED), new Manager("Vova", new Date(1000), new Date(2000)));
        dep2.addEmployee(third);
        dep2.addEmployee(fourth);
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
