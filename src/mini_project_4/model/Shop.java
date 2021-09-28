package mini_project_4.model;
import mini_project_4.exception.ValidationException;
import java.util.*;

public class Shop {

    private String shopName;

    private final Set<Contract> contracts = new HashSet<>();
    private final List<Client> clients = new ArrayList<>();

    public Shop(String shopName) {
        setShopName(shopName);
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        if (shopName == null || "".equals(shopName.trim())) {
            throw new ValidationException("shop name should not be empty");
        }
        this.shopName = shopName;
    }

    public Set<Contract> getContracts() {
        return Collections.unmodifiableSet(contracts);
    }

    public void addContract(Contract c) {
        if (c == null) {
            throw new ValidationException("contract can not be null");
        }
        if (c.getShop() != this) {
            throw new ValidationException("contract isn't connected with this shop");
        }
        this.contracts.add(c);
    }

    public void removeContract(Contract c) {
        if (c == null) {
            throw new ValidationException("contract can not be null");
        }
        this.contracts.remove(c);
        if (c.getShop() == this) {
            c.delete();
        }
    }

    public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
    }

    public void addClient(Client cl) {
        if (this.clients.contains(cl)) {
            return;
        }
        if (cl == null) {
            throw new ValidationException("client can not be null");
        }
        this.clients.add(cl);
        cl.addShops(this);
    }

    public void removeClient(Client cl) {
        if (cl == null) {
            throw new ValidationException("client can't be empty");
        }
        if (!this.clients.contains(cl)) {
            return;
        }
        this.clients.remove(cl);
        cl.removeShops(this);
    }
}