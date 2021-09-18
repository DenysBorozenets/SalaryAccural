import com.denis.model.exception.NotCorrectSalaryAmount;
import com.denis.model.workers.Employee;
import com.denis.model.workers.Manager;
import com.denis.model.workers.OtherEmployee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class EmployeeTest {
    Employee denis1;
    Employee vika1;
    Employee denis2;
    Employee vika2;


    @Before
    public void test() throws NotCorrectSalaryAmount {

//        first = new OtherEmployee("Denis", new Date(1234566789), new Date(1234567789), "Direct", "Else");
//        second = new Manager("Vika", new Date(1315773214), new Date(1442003614));
//        third = new OtherEmployee("Denis", new Date(1234566789), new Date(1234567789), "Direct", "Else");
//        fourth = new Manager("Vika", new Date(1315773214), new Date(1442003614));

        denis1 = new OtherEmployee("Denis","Dir", new Date(1234566789), new Date(1234567789));
        vika1 = new Manager("Vika", new Date(1315773214), new Date(1442003614));
        denis2 = new OtherEmployee("Denis","Dir", new Date(1234566789), new Date(1234567789));
        vika2 = new Manager("Vika", new Date(1315773214), new Date(1442003614));
    }

    @Test
    public void equalsTest() {
        Assert.assertTrue(denis1.equals(denis1));
        Assert.assertTrue(denis1.equals(denis2));
        Assert.assertTrue(denis2.equals(denis1));

        Assert.assertTrue(vika1.equals(vika1));
        Assert.assertTrue(vika1.equals(vika2));
        Assert.assertTrue(vika2.equals(vika1));

        Assert.assertFalse(denis1.equals(vika1));
        Assert.assertFalse(vika1.equals(denis1));
    }

    @Test
    public void hashTest() {
        Assert.assertEquals(vika1.hashCode(),vika1.hashCode());
        Assert.assertEquals(vika1.hashCode(),vika2.hashCode());
        Assert.assertEquals(vika2.hashCode(),vika1.hashCode());
        Assert.assertEquals(denis1.hashCode(),denis1.hashCode());
        Assert.assertEquals(denis1.hashCode(),denis2.hashCode());
        Assert.assertEquals(denis2.hashCode(),denis1.hashCode());
        Assert.assertNotEquals(denis1.hashCode(),vika1.hashCode());
        Assert.assertNotEquals(vika1.hashCode(),denis1.hashCode());
    }
}
