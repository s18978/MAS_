package mini_project_3.model.AbstractC;
import com.sun.tools.internal.ws.wsdl.framework.ValidationException;

public class Laptop extends Product {

    private int additionalRamSlot;

    public Laptop(String name, double basePrice, int additionalRamSlot) {
        super(name, basePrice);
        setAdditionalRamSlot(additionalRamSlot);
    }

    public int getAdditionalRamSlot() {
        return additionalRamSlot;
    }

    public void setAdditionalRamSlot(int additionalRamSlot) {
        if (additionalRamSlot <= 0) {
            throw new ValidationException("additional ram slot can not be null");
        }
        this.additionalRamSlot = additionalRamSlot;
    }

    @Override
    public double getPrice() {
        return getBasePrice() + additionalRamSlot*getBasePrice()/3;
    }
}