package mini_project_1.model;

import mini_project_1.exception.ValidationException;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class ProductDimensionTest {

    private double h1 = 1;
    private double h2 = 2;
    private double h3 = 3;

    private double w1 = 1;
    private double w2 = 2;
    private double w3 = 3;

    private double d1 = 1;
    private double d2 = 2;
    private double d3 = 3;

    private double s1 = 1;
    private double s2 = 2;
    private double s3 = 3;

    private ProductDimension dim1;
    private ProductDimension dim2;
    private ProductDimension dim3;

    @Before
    public void setUp() {

        dim1 = new ProductDimension(h1,w1,d1,s1);
        dim2 = new ProductDimension(h2,w2,d2,s2);
        dim3 = new ProductDimension(h3,w3,d3,s3);
    }

    @Test
    public void setHeightTest() {

        assertEquals(h1, dim1.getHeight(),0.1);
        dim1.setHeight(h2);
        assertEquals(h2, dim1.getHeight(),0.1);

        try {
            dim1.setHeight(-3);
        } catch (ValidationException e) {
            return;
        }
            fail();
    }

    @Test
    public void setWidthTest() {

        assertEquals(w1, dim1.getWidth(),0.1);
        dim1.setWidth(w2);
        assertEquals(w2, dim1.getWidth(),0.1);

        try {
            dim1.setWidth(-3);
        } catch (ValidationException e) {
            return;
        }
        fail();
    }

    @Test
    public void setDepthTest() {

        assertEquals(d1, dim1.getDepth(),0.1);
        dim1.setDepth(d2);
        assertEquals(d2, dim1.getDepth(),0.1);

        try {
            dim1.setDepth(-3);
        } catch (ValidationException e) {
            return;
        }
        fail();
    }

    @Test
    public void setScreenTest() {

        assertEquals(s1, dim1.getScreen(),0.1);
        dim1.setScreen(s2);
        assertEquals(s2, dim1.getScreen(),0.1);

        try {
            dim1.setScreen(-3);
        } catch (ValidationException e) {
            return;
        }
        fail();
    }
}