package mini_project_1.model;

import mini_project_1.exception.ValidationException;
import org.junit.Test;
import org.junit.Before;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class ProductTest {

    private double height1 = 15;
    private double height2 = 17;

    private double width1 = 5;
    private double width2 = 7;

    private double depth1 = 1;
    private double depth2 = 2;

    private double screen1 = 16;
    private double screen2 = 18;

    private ProductDimension dim1;
    private ProductDimension dim2;

    private long id1 = 0L;
    private long id2 = 1L;

    private String name1 = "name1";
    private String name2 = "name2";

    private String version1 = "ver1";
    private String version2 = "ver2";

    private String processor1 = "proc1";
    private String processor2 = "proc2";

    private int memory1 = 1024;
    private int memory2 = 2048;

    private int ram1 = 1024;
    private int ram2 = 2048;

    private String graphCard1 = "grC1";
    private String graphCard2 = "grC2";

    private LocalDate releaseDate1 = LocalDate.of(2020, 4, 5);
    private LocalDate releaseDate2 = LocalDate.of(2021, 4, 5);

    private String type1 = "forWork";
    private String type2 = "forGames";

    private String color1 = "silver";
    private String color2 = "black";

    private double price1 = 400;
    private double price2 = 500;

    private double discount1 = 50;
    private double discount2 = 60;

    private String backlight1 = "backlight1";
    private String backlight2 = "backlight2";

    private Product pr1;
    private Product pr2;

    @Before
    public void setUp() {

        dim1 = new ProductDimension(height1, width1, depth1, screen1);
        dim2 = new ProductDimension(height2, width2, depth2, screen2);

        pr1 = new Product(id1, name1, version1, processor1, memory1, ram1, graphCard1, releaseDate1, type1, color1, ProductRating._1, price1, dim1);
        pr2 = new Product(id2, name2, version2, processor2, memory2, ram2, graphCard2, releaseDate2, type2, color2, ProductRating._3, price2, backlight2, discount2, dim2);
    }

    @Test
    public void addTypeTest() {

        assertTrue(pr1.getType().contains(type1));
        assertEquals(1, pr1.getType().size());

        pr1.addType(type2);

        assertTrue(pr1.getType().contains(type2));
        assertEquals(2, pr1.getType().size());

        int counter = 0;

        try {
            pr1.addType(" ");
        } catch (ValidationException e) {
            counter++;
        }

        try {
            pr1.addType(null);
        } catch (ValidationException e) {
            counter++;
        }

        if (counter != 2) {
            fail();
        }
    }

    @Test
    public void removeTypeTest() {

        pr1.addType(type2);
        assertTrue(pr1.getType().contains(type1));
        assertTrue(pr1.getType().contains(type2));
        assertEquals(2, pr1.getType().size());

        pr1.removeType(type1);

        assertFalse(pr1.getType().contains(type1));
        assertTrue(pr1.getType().contains(type2));
        assertEquals(1, pr1.getType().size());

        int counter = 0;

        try {
            pr1.removeType(" ");
        } catch (ValidationException e) {
            counter++;
        }

        try {
            pr1.removeType(null);
        } catch (ValidationException e) {
            counter++;
        }

        try {
            pr1.removeType(type2);
        } catch (ValidationException e) {
            counter++;
        }

        if (counter != 3) {
            fail();
        }
    }

    @Test
    public void setIdTest() {
        assertEquals(id1, pr1.getId());
        pr1.setId(id2);
        assertEquals(id2, pr1.getId());
    }

    @Test
    public void setNameTest() {
        assertEquals(name1, pr1.getName());
        pr1.setName(name2);
        assertEquals(name2, pr1.getName());

        int counter = 0;

        try {
            pr1.setName(" ");
        } catch (ValidationException e) {
            counter++;
        }

        try {
            pr1.setName(null);
        } catch (ValidationException e) {
            counter++;
        }

        if (counter != 2) {
            fail();
        }
    }

    @Test
    public void setVersionTest() {

        assertEquals(version1, pr1.getVersion());
        pr1.setVersion(version2);
        assertEquals(version2, pr1.getVersion());

        int counter = 0;

        try {
            pr1.setVersion(" ");
        } catch (ValidationException e) {
            counter++;
        }

        try {
            pr1.setVersion(null);
        } catch (ValidationException e) {
            counter++;
        }
        if (counter != 2) {
            fail();
        }
    }

    @Test
    public void setProcessorTest() {

        assertEquals(processor1, pr1.getProcessor());
        pr1.setProcessor(processor2);
        assertEquals(processor2, pr1.getProcessor());

        int counter = 0;

        try {
            pr1.setProcessor(" ");
        } catch (ValidationException e) {
            counter++;
        }

        try {
            pr1.setProcessor(null);
        } catch (ValidationException e) {
            counter++;
        }
        if (counter != 2) {
            fail();
        }
    }

    @Test
    public void setMemoryTest() {
        assertEquals(memory1, pr1.getMemory(), 0.1);
        pr1.setMemory(memory2);
        assertEquals(memory2, pr1.getMemory(), 0.1);

        try {
            pr1.setMemory(-3);
        } catch (ValidationException e) {
            return;
        }
        fail();
    }

    @Test
    public void setRamTest() {
        assertEquals(ram1, pr1.getRam(), 0.1);
        pr1.setRam(ram2);
        assertEquals(ram2, pr1.getRam(), 0.1);

        try {
            pr1.setRam(-3);
        } catch (ValidationException e) {
            return;
        }
        fail();
    }

    @Test
    public void setGraphicCardTest() {

        assertEquals(graphCard1, pr1.getGraphicCard());
        pr1.setGraphicCard(graphCard2);
        assertEquals(graphCard2, pr1.getGraphicCard());

        int counter = 0;

        try {
            pr1.setGraphicCard(" ");
        } catch (ValidationException e) {
            counter++;
        }

        try {
            pr1.setGraphicCard(null);
        } catch (ValidationException e) {
            counter++;
        }
        if (counter != 2) {
            fail();
        }
    }

    @Test
    public void setReleaseDateTest() {

        assertEquals(releaseDate1, pr1.getReleaseDate());
        pr1.setReleaseDate(releaseDate2);
        assertEquals(releaseDate2, pr1.getReleaseDate());

        int counter = 0;

        try {
            pr1.setReleaseDate(null);
        } catch (ValidationException e) {
            counter++;
        }
    }

    @Test
    public void setColorTest() {

        assertEquals(color1, pr1.getColor());
        pr1.setColor(color2);
        assertEquals(color2, pr1.getColor());

        int counter = 0;

        try {
            pr1.setColor(" ");
        } catch (ValidationException e) {
            counter++;
        }

        try {
            pr1.setColor(null);
        } catch (ValidationException e) {
            counter++;
        }
        if (counter != 2) {
            fail();
        }
    }

    @Test
    public void setRatingTest() {

        assertEquals(ProductRating._1, pr1.getRating());
        pr1.setRating(ProductRating._2);
        assertEquals(ProductRating._2, pr1.getRating());

        try {
            pr1.setRating(null);
        } catch (ValidationException e) {
            return;
        }
        fail();
    }

    @Test
    public void setPriceTest() {

        assertEquals(price1, pr1.getPrice(), 0.1);
        pr1.setPrice(price2);
        assertEquals(price2, pr1.getPrice(), 0.1);

        try {
            pr1.setPrice(-3);
        } catch (ValidationException e) {
            return;
        }
        fail();
    }

    @Test
    public void setBacklightTest() {

        assertEquals(backlight2, pr2.getBacklight());
        pr2.setBacklight(backlight1);
        assertEquals(backlight1, pr2.getBacklight());


        pr2.setBacklight(null);
        assertNull(pr2.getBacklight());
        try {
            pr1.setBacklight(" ");
        } catch (ValidationException e) {
            return;
        }
        fail();

    }

    @Test
    public void setDiscountTest() {

        assertEquals(discount2, pr2.getDiscount(), 0.1);
        pr2.setDiscount(discount1);
        assertEquals(discount1, pr2.getDiscount(), 0.1);

        pr2.setDiscount(null);
        assertNull(pr2.getDiscount());
        try {
            pr2.setDiscount(-3.);
        } catch (ValidationException e) {
            return;
        }
        fail();
    }

    @Test
    public void setDimensionTest() {

        assertEquals(dim1, pr1.getDimension());
        pr1.setDimension(dim2);
        assertEquals(dim2, pr1.getDimension());

        try {
            pr1.setDimension(null);
        } catch (ValidationException e) {
            return;
        }
        fail();
    }

    @Test
    public void addProductColorTest() {

        assertFalse(Product.getProductColor().contains(color1));

        Product.addProductColor(color1);
        assertTrue(Product.getProductColor().contains(color1));

        int counter = 0;

        try {
            Product.addProductColor("   ");
        } catch (ValidationException e) {
            counter++;
        }

        try {
            Product.addProductColor(null);
        } catch (ValidationException e) {
            counter++;
        }

        if (counter != 2) {
            fail();
        }
    }

    @Test
    public void removeProductColorTest() {

        Product.addProductColor(color1);
        assertTrue(Product.getProductColor().contains(color1));
        Product.removeProductColor(color1);

        assertFalse(Product.getProductColor().contains(color1));

        int counter = 0;

        try {
            Product.removeProductColor(" ");
        } catch (ValidationException e) {
            counter++;
        }

        try {
            Product.removeProductColor(null);
        } catch (ValidationException e) {
            counter++;
        }

        if (counter != 2) {
            fail();
        }
    }

    @Test
    public void getTotalPriceTest() {
        assertEquals(pr2.getPrice() - pr2.getDiscount(), pr2.getTotalPrice(), 0.1);
    }

    @Test
    public void getAge() {
        Period per = Period.between(pr1.getReleaseDate(), LocalDate.now());
        assertEquals(per.getDays(), pr1.getAge().getDays());
        assertEquals(per.getMonths(), pr1.getAge().getMonths());
        assertEquals(per.getYears(), pr1.getAge().getYears());
    }

    @Test
    public void saveLoadExtentTest() {

        Product.saveExtent();
        List<Product> products = new ArrayList<>(Product.getExtent());

        Product.loadExtent();
        assertEquals(products.size(), Product.getExtent().size());

    }

    @Test
    public void findByColorTest() {
        assertTrue(Product.findByColor(color1).contains(pr1));

        int counter = 0;

        try {
            Product.findByColor("  ");
        } catch (ValidationException e) {
            counter++;
        }

        try {
            Product.findByColor(null);
        } catch (ValidationException e) {
            counter++;
        }

        if (counter != 2) {
            fail();
        }
    }

    @Test
    public void findByPriceRangeTest() {
        assertTrue(Product.findByPriceRange(300, 450).contains(pr1));

        int counter = 0;

        try {
            Product.findByPriceRange(-1, 4);
        } catch (ValidationException e) {
            counter++;
        }

        try {
            Product.findByPriceRange(500, 100);
        } catch (ValidationException e) {
            counter++;
        }

        if (counter != 2) {
            fail();
        }
    }
}