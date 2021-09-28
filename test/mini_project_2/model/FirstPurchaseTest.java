package mini_project_2.model;

import org.junit.Test;
import org.junit.Before;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class FirstPurchaseTest {

    private Shop shop1;
    private Shop shop2;

    private Client client1;
    private Client client2;
    private Client client3;

    private FirstPurchase firstPurchase1;
    private FirstPurchase firstPurchase2;
    private FirstPurchase firstPurchase3;

    @Before
    public void setUp(){
        shop1 = new Shop("name",new Worker("n","s","999999999"));
        shop2 = new Shop("name",new Worker("n","s","999999999"));

        client1 = new Client("n","s","999999999");
        client2 = new Client("n","s","999999999");
        client3 = new Client("n","s","999999999");

        firstPurchase1 = new FirstPurchase(LocalDate.now(),10,client1,shop1);
        firstPurchase2 = new FirstPurchase(LocalDate.now(),10,client2,shop1);
        firstPurchase3 = new FirstPurchase(LocalDate.now(),10,client3,shop2);

    }

    @Test
    public void createAssociationTest(){

        assertEquals(client1,firstPurchase1.getClient());
        assertEquals(shop1,firstPurchase1.getShop());

        assertEquals(firstPurchase1,client1.getFirstPurchase());
        assertTrue(shop1.getPurchases().contains(firstPurchase1));

    }

    @Test
    public void SwapAssociationTest(){
        FirstPurchase tmp = new FirstPurchase(LocalDate.now(),10,client1,shop2);
        assertEquals(client1,tmp.getClient());
        assertEquals(shop2,tmp.getShop());

        assertEquals(tmp,client1.getFirstPurchase());
        assertTrue(shop2.getPurchases().contains(tmp));

        assertNotEquals(client1,firstPurchase1.getClient());
        assertNotEquals(shop1,firstPurchase1.getShop());

        assertNotEquals(firstPurchase1,client1.getFirstPurchase());
        assertFalse(shop1.getPurchases().contains(firstPurchase1));

    }

    @Test
    public void DeleteAssociationTest(){
        client1.setFirstPurchase(null);

        assertNull(client1.getFirstPurchase());
        assertFalse(shop1.getPurchases().contains(firstPurchase1));

        shop1.removeFirstPurchase(firstPurchase2);
        assertNull(client2.getFirstPurchase());
        assertFalse(shop1.getPurchases().contains(firstPurchase2));

    }


}
