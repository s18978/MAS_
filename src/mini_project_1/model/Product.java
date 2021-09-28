package mini_project_1.model;
import mini_project_1.exception.ValidationException;
import mini_project_2.model.ProductDetail;
import mini_project_2.model.Shop;
import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Product implements Serializable {

    private static final String EXTENT_FILENAME = "./data/Product.ser";
    private static List<Product> extent = new ArrayList<>();

    private long id;
    private String name;
    private String version;
    private String processor;
    private int memory;
    private int ram;
    private String graphicCard;
    private LocalDate releaseDate;
    private final List<String> type = new ArrayList<>();
    private String color;
    private ProductRating rating;
    private double price;
    private String backlight;
    private Double discount;

    private ProductDimension dimension;

    private Shop inStock;

    private static final Set<String> productColor = new HashSet<>();

    private Set<ProductDetail> productDetails = new HashSet<>();

    // mandatory
    public Product(long id, String name, String version, String processor, int memory, int ram,
                   String graphicCard, LocalDate releaseDate, String type, String color,
                   ProductRating rating, double price, ProductDimension dimension) {

        setId(id);
        setName(name);
        setVersion(version);
        setProcessor(processor);
        setMemory(memory);
        setRam(ram);
        setGraphicCard(graphicCard);
        setReleaseDate(releaseDate);
        addType(type);
        setColor(color);
        setRating(rating);
        setPrice(price);
        setDimension(dimension);
        extent.add(this);
    }

    // + backlight, discount
    public Product(long id, String name, String version, String processor, int memory, int ram,
                   String graphicCard, LocalDate releaseDate, String type, String color,
                   ProductRating rating, double price, String backlight, double discount,
                   ProductDimension dimension) {

        setId(id);
        setName(name);
        setVersion(version);
        setProcessor(processor);
        setMemory(memory);
        setRam(ram);
        setGraphicCard(graphicCard);
        setReleaseDate(releaseDate);
        addType(type);
        setColor(color);
        setRating(rating);
        setPrice(price);
        setBacklight(backlight);
        setDiscount(discount);
        setDimension(dimension);
        extent.add(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new ValidationException("name should not be empty");
        }
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        if(version == null || "".equals(version.trim())) {
            throw new ValidationException("version should not be empty");
        }
        this.version = version;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        if(processor == null || "".equals(processor.trim())) {
            throw new ValidationException("processor should not be empty");
        }
        this.processor = processor;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        if (memory <= 0) {
            throw new ValidationException("memory should not be negative");
        }
        this.memory = memory;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        if (ram <= 0) {
            throw new ValidationException("ram should not be negative");
        }
        this.ram = ram;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        if(graphicCard == null || "".equals(graphicCard.trim())) {
            throw new ValidationException("graphic card should not be empty");
        }
        this.graphicCard = graphicCard;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        if (releaseDate == null) {
            throw new ValidationException("release date should not be null");
        }
        this.releaseDate = releaseDate;
    }

    public Period getAge() {
        return Period.between(releaseDate, LocalDate.now());
    }

    public List<String> getType() {
        return Collections.unmodifiableList(this.type);
    }

    public void addType(String type) {
        if(type == null || "".equals(type.trim())) {
            throw new ValidationException("type should not be empty");
        }
        this.type.add(type);
    }

    public void removeType(String type) {
        if(type == null || "".equals(type.trim())) {
            throw new ValidationException("type should not be empty");
        }
        if(this.type.size() <= 1) {
            throw new ValidationException("can not delete the last type");
        }
        this.type.remove(type);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if(color == null || "".equals(color.trim())) {
            throw new ValidationException("color should not be empty");
        }
        this.color = color;
    }

    public ProductRating getRating() {
        return rating;
    }

    public void setRating(ProductRating rating) {
        if(rating == null) {
            throw new ValidationException("rating should not be null");
        }
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0) {
            throw new ValidationException("price should not be negative");
        }
        this.price = price;
    }

    public double getTotalPrice() {
        if(discount != null) {
            return price - discount;
        }
        return price;
    }

    public String getBacklight() {
        return backlight;
    }

    public void setBacklight(String backlight) {
        if(backlight != null && "".equals(backlight.trim())) {
            throw new ValidationException("backlight should not be empty");
        }
        this.backlight = backlight;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        if(discount != null && discount < 0) {
            throw new ValidationException("discount should not be negative");
        }
        this.discount = discount;
    }

    public ProductDimension getDimension() {
        return dimension;
    }

    public void setDimension(ProductDimension dimension) {
        if(dimension == null) {
            throw new ValidationException("dimension should not be empty");
        }
        this.dimension = dimension;
    }

    public static Set<String> getProductColor() {
        return Collections.unmodifiableSet(productColor);
    }

    public static void addProductColor(String pc) {
        if(pc == null || "".equals(pc.trim())) {
            throw new ValidationException("product colors should not be empty");
        }
        productColor.add(pc);
    }

    public static void removeProductColor(String pc) {
        if(pc == null || "".equals(pc.trim())) {
            throw new ValidationException("product colors should not be empty");
        }
        productColor.remove(pc);
    }

    public static List<Product> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public static void saveExtent() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(EXTENT_FILENAME))) {
            objectOutputStream.writeObject(extent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadExtent() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(EXTENT_FILENAME))) {
            extent = (List<Product>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> findByColor(String c) {

        if (c == null || "".equals(c.trim())) {
            throw new ValidationException("price can not be negative");
        }
        return extent.stream()
                .filter(p -> p.color.contains(c)).collect(Collectors.toList());
    }

    public static List<Product> findByPriceRange(double min, double max) {
        if(min < 0 || max < 0) {
            throw new ValidationException("price can not be negative");
        }
        if(max < min) {
            throw new ValidationException("max price can not be lover than minimum");
        }
        return extent.stream()
                .filter(p -> p.price > min && p.price < max)
                .collect(Collectors.toList());
    }

    public Shop getInStock() {
        return inStock;
    }

    public void setInStock(Shop inStock) {
        if(this.inStock == inStock) {
            return;
        }
        if(this.inStock != null){
            this.inStock.deleteProduct(this);
        }
        this.inStock = inStock;
        if(this.inStock != null){
            this.inStock.addProduct(this);
        }
    }

    public Set<ProductDetail> getProductDetails() {
        return Collections.unmodifiableSet(productDetails);
    }

    public void addProductDetail(ProductDetail pr) {
        if(pr == null){
            throw new ValidationException("Product detail can't be empty");
        }
        if(pr.getProduct() != this) { // checks if detail belongs to product
            throw new ValidationException("this detail already belongs to another product");
        }
        this.productDetails.add(pr);

    }
    public void deleteProductDetail(ProductDetail pr) {
        if(pr == null){
            throw new ValidationException("Product detail can't be empty");
        }
        if(this.productDetails.contains(pr)) {
            this.productDetails.remove(pr);
            pr.delete();
        }
    }

    public void delete() {

        setInStock(null);

        for(ProductDetail pr: new ArrayList<>(productDetails)) {
            pr.delete();
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", processor='" + processor + '\'' +
                ", memory=" + memory +
                ", ram=" + ram +
                ", graphicCard='" + graphicCard + '\'' +
                ", releaseDate=" + releaseDate +
                ", type=" + type +
                ", color='" + color + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", backlight='" + backlight + '\'' +
                ", discount=" + discount +
                ", dimension=" + dimension +
                '}';
    }
}