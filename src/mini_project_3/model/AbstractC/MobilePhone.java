package mini_project_3.model.AbstractC;

public class MobilePhone extends Product {

    private boolean protectiveScreen;

    public MobilePhone(String name, double basePrice, boolean protectiveScreen) {
        super(name, basePrice);
        setProtectiveScreen(protectiveScreen);
    }

    public boolean hasProtectiveScreen() {
        return protectiveScreen;
    }

    public void setProtectiveScreen(boolean protectiveScreen) {
        this.protectiveScreen = protectiveScreen;
    }

    @Override
    public double getPrice() {
        return getBasePrice() * (protectiveScreen? 1.5:1);
    }
}