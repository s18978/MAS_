package mini_project_2.model;
import mini_project_1.exception.ValidationException;
import mini_project_1.model.Product;

public class ProductDetail {

    private String name;

    private Product product;

    public ProductDetail(String name, Product productDetail) {
        setName(name);
        setProduct(productDetail);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new ValidationException("name can not be empty");
        }
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    private void setProduct(Product product) {
        if (product == null) {
            throw new ValidationException("product detail should not be null");
        }
        this.product = product;
        product.addProductDetail(this);
    }

    public void delete() {
        product.deleteProductDetail(this);
        this.product = null;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "ProductDetail{ " + "name=" + name + '}';
    }
}