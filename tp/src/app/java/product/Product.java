package product;

public class Product {
    public int code;

    public Product(int code, String description, double price, String unit) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}