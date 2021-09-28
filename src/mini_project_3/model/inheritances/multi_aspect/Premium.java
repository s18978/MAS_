package mini_project_3.model.inheritances.multi_aspect;
import mini_project_3.exception.ValidationException;

public class Premium extends Status {

    private double discount;

    public Premium(double discount) {
        setDiscount(discount);
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if (discount == 0) {
            throw new ValidationException("discount should not be null");
        }
        this.discount = discount;
    }
}