package product;

public class Product {
    public int code;
    public String description;
    public double price;

    public Product(int code, String description, double price, String unit) {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }
}