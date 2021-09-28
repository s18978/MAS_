package mini_project_3.model.inheritances.multi;

public class ClientImpl extends Person implements Client {

    private boolean loyaltyCard;

    public ClientImpl(String name, String surname, String phoneNumber, boolean loyaltyCard) {
        super(name, surname, phoneNumber);
        setLoyaltyCard(loyaltyCard);
    }

    @Override
    public boolean hasLoyaltyCard() {
        return loyaltyCard;
    }

    @Override
    public void setLoyaltyCard(boolean loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }

}