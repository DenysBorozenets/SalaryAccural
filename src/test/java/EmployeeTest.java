import com.denis.model.workers.Employee;
import com.denis.model.workers.Manager;
import com.denis.model.workers.OtherEmployee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class EmployeeTest {
    Employee first;
    Employee second;
    Employee third;
    Employee fourth;


    @Before
    public void test() {

        first = new OtherEmployee("Denis", new Date(1234566789), new Date(1234567789), "Direct", "Else");
        second = new Manager("Vika", new Date(1315773214), new Date(1442003614));
        third = new OtherEmployee("Denis", new Date(1234566789), new Date(1234567789), "Direct", "Else");
        fourth = new Manager("Vika", new Date(1315773214), new Date(1442003614));
    }

    @Test
    public void equalsTest() {
        Assert.assertTrue(first.equals(first));
        Assert.assertTrue(first.equals(third));
        Assert.assertTrue(third.equals(first));

        Assert.assertTrue(second.equals(second));
        Assert.assertTrue(second.equals(fourth));
        Assert.assertTrue(fourth.equals(second));

        Assert.assertFalse(first.equals(second));
        Assert.assertFalse(second.equals(first));
    }

    @Test
    public void hashTest() {
        Assert.assertEquals(second.hashCode(),second.hashCode());
        Assert.assertEquals(second.hashCode(),fourth.hashCode());
        Assert.assertEquals(fourth.hashCode(),second.hashCode());
        Assert.assertEquals(first.hashCode(),first.hashCode());
        Assert.assertEquals(first.hashCode(),third.hashCode());
        Assert.assertEquals(third.hashCode(),first.hashCode());
        Assert.assertNotEquals(first.hashCode(),second.hashCode());
        Assert.assertNotEquals(second.hashCode(),first.hashCode());
    }
}
