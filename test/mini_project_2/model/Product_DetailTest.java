package mini_project_2.model;

import mini_project_1.exception.ValidationException;
import mini_project_1.model.Product;
import mini_project_1.model.ProductDimension;
import mini_project_1.model.ProductRating;
import org.junit.Test;
import org.junit.Before;

import java.time.LocalDate;

import static org.junit.Assert.*;


public class Product_DetailTest {

    private Product product1;
    private Product product2;

    private ProductDetail detail1;
    private ProductDetail detail2;
    private ProductDetail detail3;
    private ProductDetail detail4;


    @Before
    public void setUp(){
        product1 = new Product(1, "n", "f", "d", 12, 12, "d", LocalDate.now(), "dfsdf", "sd", ProductRating._1, 1, new ProductDimension(1,2,2,2));
        product2 = new Product(2, "n", "f", "d", 12, 12, "d", LocalDate.now(), "dfsdf", "sd", ProductRating._1, 1, new ProductDimension(1,2,2,2));

        detail1 = new ProductDetail("s",product1);
        detail2 = new ProductDetail("s",product1);
        detail3 = new ProductDetail("s",product2);
        detail4 = new ProductDetail("s",product2);
    }

    @Test
    public void createAssociationTest(){
        assertEquals(product1,detail1.getProduct());
        assertTrue(product1.getProductDetails().contains(detail1));
    }

    @Test
    public void SwapAssociationTest(){
        try {
            product1.addProductDetail(detail3);
        } catch (ValidationException e) {
            return;
        }
        fail();

    }

    @Test
    public void DeleteAssociationTest() {
        detail1.delete();

        assertNull(detail1.getProduct());
        assertFalse(product1.getProductDetails().contains(detail1));

        product1.deleteProductDetail(detail2);
        assertNull(detail2.getProduct());
        assertFalse(product1.getProductDetails().contains(detail2));

        product2.delete();
        assertEquals(0,product2.getProductDetails().size());
        assertNull(detail3.getProduct());
    }
}
