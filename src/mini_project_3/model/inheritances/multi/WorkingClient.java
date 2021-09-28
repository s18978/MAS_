package mini_project_3.model.inheritances.multi;
import com.sun.tools.internal.ws.wsdl.framework.ValidationException;

public class WorkingClient extends Worker implements Client {

    private boolean loyaltyCard;

    private double workerDiscount;

    public WorkingClient(String name, String surname, String phoneNumber, double salary, boolean loyaltyCard, double workerDiscount) {
        super(name, surname, phoneNumber, salary);
        setLoyaltyCard(loyaltyCard);
        setWorkerDiscount(workerDiscount);
    }

    @Override
    public boolean hasLoyaltyCard() {
        return loyaltyCard;
    }

    @Override
    public void setLoyaltyCard(boolean loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }

    public double hasWorkerDiscount() {
        return workerDiscount;
    }

    public void setWorkerDiscount(double workerDiscount) {
        if (workerDiscount == 0) {
            throw new ValidationException("worker discount should not be null");
        }
        this.workerDiscount = workerDiscount;
    }
}