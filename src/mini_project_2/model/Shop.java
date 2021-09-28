package mini_project_2.model;
import mini_project_1.exception.ValidationException;
import mini_project_1.model.Product;
import java.util.*;

public class Shop {

    private String shopName;

    private final Set<Worker> workers = new HashSet<>();

    private final Set<FirstPurchase> purchases = new HashSet<>();

    private final Map<Long, Product> products = new HashMap<>();

    //mandatory
    public Shop(String shopName, Worker worker) {
        setShopName(shopName);
        addWorker(worker);
    }

    public Shop(String shopName, Worker worker, FirstPurchase purchase) {
        setShopName(shopName);
        addWorker(worker);
        addFirstPurchase(purchase);
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        if(shopName == null || "".equals(shopName.trim())) {
            throw new ValidationException("shop name should not be empty");
        }
        this.shopName = shopName;
    }

    public Set<Worker> getWorkers() {
        return Collections.unmodifiableSet(workers);
    }

    public void addWorker(Worker w) {
        if(w == null) {
            throw new ValidationException("worker can not be null");
        }
        if(this.workers.contains(w)) {
            return;
        }
        this.workers.add(w);
        w.setWorkingPlace(this);
    }

    public void removeWorker(Worker w) {
        if(w == null) {
            throw new ValidationException("worker can't be empty");
        }
        if(!this.workers.contains(w)) {
            return;
        }
        if(this.workers.size() <= 1) {
            throw new ValidationException("can not delete last worker");
        }
        this.workers.remove(w);
        w.setWorkingPlace(null);
    }

    public Set<FirstPurchase> getPurchases() {
        return Collections.unmodifiableSet(purchases);
    }

    public void addFirstPurchase(FirstPurchase p) {
        if(p == null) {
            throw new ValidationException("purchase can not be null");
        }
        if(p.getShop() != this) {
            throw new ValidationException("purchase isn't connected with this shop");
        }
        this.purchases.add(p);
    }

    public void removeFirstPurchase(FirstPurchase p) {
        if(p == null) {
            throw new ValidationException("purchase can not be null");
        }
        this.purchases.remove(p);
        if(p.getShop() == this) {
            p.delete();
        }
    }

    public Map<Long, Product> getProducts() {
        return Collections.unmodifiableMap(products);
    }

    public List<Product> getProductList() {
        return new ArrayList<>(products.values());
    }

    public Product findProductById(long productId) {
        return products.get(productId);
    }

    public void addProduct(Product p) {
        if(p == null) {
            throw new ValidationException("product should not be null");
        }
        if(products.containsKey(p.getId())) {
            return;
        }
        products.put(p.getId(), p);
        p.setInStock(this);
    }

    public void deleteProduct(Product p) {
        if(p == null) {
            throw new ValidationException("product should not be null");
        }
        if(!products.containsKey(p.getId())) {
            return;
        }
        Product tmp = products.get(p.getId());
        products.remove(p.getId(), p);
        tmp.setInStock(null);
    }


}