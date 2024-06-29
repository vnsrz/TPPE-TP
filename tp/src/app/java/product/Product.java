package product;

public class Product {
    public int code;
    public String description;

    public Product(int code, String description, double price, String unit) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}