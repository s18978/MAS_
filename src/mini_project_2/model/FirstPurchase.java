package mini_project_2.model;
import mini_project_1.exception.ValidationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FirstPurchase {

    private static List<FirstPurchase> extent = new ArrayList<>();

    private LocalDate purchaseDate;
    private double price;

    private Client client;
    private Shop shop;

    public FirstPurchase(LocalDate purchaseDate, double price, Client client, Shop shop) {
        setPurchaseDate(purchaseDate);
        setPrice(price);
        if(client == null || shop == null) {
            throw new ValidationException("ClientImpl or shop cannot be null");
        }
        setClient(client);
        setShop(shop);
        if(!dublicate(client, shop)) {
            throw new ValidationException("association must be unique");
        }
        extent.add(this);
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        if (purchaseDate == null) {
            throw new ValidationException("date of purchase can not be null");
        }
        this.purchaseDate = purchaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new ValidationException("price should not be negative");
        }
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public Shop getShop() {
        return shop;
    }

    private void setClient(Client client) {
        Client tmp = this.client;
        this.client = client;
        if(client == null && tmp != null) {
            tmp.setFirstPurchase(null);
        }

        if(client != null) {
            client.setFirstPurchase(this);
        }
    }
    private void setShop(Shop shop) {
        Shop tmp = this.shop;
        this.shop = shop;
        if(tmp != null) {
            tmp.removeFirstPurchase(this);
        }
        if(shop != null) {
            shop.addFirstPurchase(this);
        }
    }
    public void delete() {
        if(this.client != null) {
            setClient(null);
        }
        if(this.shop != null) {
            setShop(null);
        }
    }
    public static boolean dublicate(Client c, Shop s) {
        return extent.stream().noneMatch(cl -> cl.client == c && cl.shop == s);
    }
}