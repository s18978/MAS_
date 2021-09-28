package mini_project_3.model.inheritances.multi_aspect;

public class Client extends Person {

    private boolean loyaltyCard;

    public Client(String name, String surname, String phoneNumber, Status status, boolean loyaltyCard) {
        super(name, surname, phoneNumber, status);
        setLoyaltyCard(loyaltyCard);
    }

    public boolean hasLoyaltyCard() {
        return loyaltyCard;
    }

    public void setLoyaltyCard(boolean loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }
}