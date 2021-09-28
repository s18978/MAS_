package mini_project_2.model;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class Shop_WorkerTest {

    private Shop shop1;
    private Shop shop2;

    private Worker worker1;
    private Worker worker2;
    private Worker worker3;

    @Before
    public void setUp(){
        worker1 = new Worker("name","surname","999999999");
        worker2 = new Worker("name","surname","999999999");
        worker3 = new Worker("name","surname","999999999");


        shop1 = new Shop("name",worker1);
        shop2 = new Shop("name",worker2);

        shop2.addWorker(worker3);
    }

    @Test
    public void createAssociationTest(){
        assertTrue(shop1.getWorkers().contains(worker1));
        assertTrue(shop2.getWorkers().contains(worker2));

        assertEquals(shop1,worker1.getWorkingPlace());
        assertEquals(shop2,worker2.getWorkingPlace());
    }

    @Test
    public void SwapAssociationTest(){

        shop1.addWorker(worker3);

        assertTrue(shop1.getWorkers().contains(worker3));
        assertFalse(shop2.getWorkers().contains(worker3));

        assertEquals(shop1,worker3.getWorkingPlace());

        worker3.setWorkingPlace(shop2);

        assertTrue(shop2.getWorkers().contains(worker3));
        assertFalse(shop1.getWorkers().contains(worker3));

        assertEquals(shop2,worker3.getWorkingPlace());

    }

    @Test
    public void DeleteAssociationTest(){
        worker2.setWorkingPlace(null);

        assertFalse(shop2.getWorkers().contains(worker2));
        assertNull(worker2.getWorkingPlace());

        worker2.setWorkingPlace(shop2);

        System.out.println(worker2.getWorkingPlace().getWorkers().size());
        System.out.println(shop2.getWorkers().size());

        shop2.removeWorker(worker2);

        assertFalse(shop2.getWorkers().contains(worker2));
        assertNull(worker2.getWorkingPlace());
    }


}
