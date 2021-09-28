package mini_project_3.model.AbstractC;
import com.sun.tools.internal.ws.wsdl.framework.ValidationException;

public abstract class Product {

    private String name;
    private double basePrice;

    public Product(String name, double basePrice) {
        setName(name);
        setBasePrice(basePrice);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new ValidationException("name can not be null");
        }
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice == 0) {
            throw new ValidationException("price can not be null");
        }
        this.basePrice = basePrice;
    }

    public abstract double getPrice();
}