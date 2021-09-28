package mini_project_3.model.AbstractC;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AbstractC_Test {

    private Laptop laptop;
    private MobilePhone mobilePhone;

    @Before
    public void setUp() {

        laptop = new Laptop("name1", 2000.0, 100);
        mobilePhone = new MobilePhone("name1", 1000.0, true);
    }

    @Test
    public void test() {

        List<Product> list = new ArrayList<>();
        list.add(laptop);
        list.add(mobilePhone);
        assertTrue(list.contains(laptop));
        assertTrue(list.contains(mobilePhone));

        assertNotEquals(list.get(0).getPrice(),list.get(1).getPrice());
    }
}