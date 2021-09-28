package mini_project_2.model;

import mini_project_1.model.Product;
import mini_project_1.model.ProductDimension;
import mini_project_1.model.ProductRating;
import org.junit.Test;
import org.junit.Before;

import java.time.LocalDate;

import static org.junit.Assert.*;


public class Product_ShopTest {

    private Shop shop1;
    private Shop shop2;

    private Product product1;
    private Product product2;
    private Product product3;

    @Before
    public void setUp(){
        shop1 = new Shop("name",new Worker("n","s","999999999"));
        shop2 = new Shop("name",new Worker("n","s","999999999"));

        product1 = new Product(1, "n", "f", "d", 12, 12, "d", LocalDate.now(), "dfsdf", "sd", ProductRating._1, 1, new ProductDimension(1,2,2,2));
        product2 = new Product(2, "n", "f", "d", 12, 12, "d", LocalDate.now(), "dfsdf", "sd", ProductRating._1, 1, new ProductDimension(1,2,2,2));
        product3 = new Product(3, "n", "f", "d", 12, 12, "d", LocalDate.now(), "dfsdf", "sd", ProductRating._1, 1, new ProductDimension(1,2,2,2));

        shop1.addProduct(product1);
        shop1.addProduct(product2);
        product3.setInStock(shop2);
    }

    @Test
    public void createAssociationTest(){
        assertEquals(shop1,product1.getInStock());
        assertEquals(shop1,product2.getInStock());
        assertEquals(shop2,product3.getInStock());

        assertTrue(shop1.getProducts().containsKey(product1.getId()));
        assertTrue(shop1.getProducts().containsKey(product2.getId()));
        assertTrue(shop2.getProducts().containsKey(product3.getId()));
    }

    @Test
    public void SwapAssociationTest(){
        shop2.addProduct(product1);
        assertEquals(shop2,product1.getInStock());

        assertFalse(shop1.getProducts().containsKey(product1.getId()));

        product1.setInStock(shop1);

        assertEquals(shop1,product1.getInStock());
        assertTrue(shop1.getProducts().containsKey(product1.getId()));

    }

    @Test
    public void DeleteAssociationTest(){
        shop1.deleteProduct(product1);

        assertFalse(shop1.getProducts().containsKey(product1));

        product2.setInStock(null);

        assertFalse(shop1.getProducts().containsKey(product2));

    }

}
