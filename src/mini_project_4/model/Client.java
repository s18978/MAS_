package mini_project_4.model;
import mini_project_4.exception.ValidationException;
import java.util.ArrayList;
import java.util.List;

public class Client {

    private String name;

    private final List<Shop> shops = new ArrayList<>();

    private Account account;

    public Client(String name) { //not add a shop because client do not mandatory have a shop
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new ValidationException("name cant be null");
        }
        this.name = name;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void addShops(Shop s) {
        if(s == null) {
            throw new ValidationException("shop can not be null");
        }
        if(this.shops.contains(s)) {
            return;
        }
        this.shops.add(s);
        s.addClient(this);
    }

    public void removeShops(Shop s) {
        if(s == null) {
            throw new ValidationException("shop can't be empty");
        }
        if(!this.shops.contains(s)) {
            return;
        }
        this.shops.remove(s);
        s.removeClient(this);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        if(this.account == account) {
            return;
        }
        if(this.account == null) {
            this.account = account;
            account.setClient(this);
        } else if (account == null) {
            Account a = this.account;
            this.account = null;
            a.setClient(null);
        }
        else {
            setAccount(null);
            setAccount(account);
        }
    }
}