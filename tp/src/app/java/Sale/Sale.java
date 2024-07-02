package Sale;

import customer.Customer;
import product.Product;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class Sale {
    private Date date;
    private Customer customer;
    private ArrayList<Product> product;
    private String paymentMethod;

    private float amount;

    public Sale(Date date, Customer customer, ArrayList<Product> product, String paymentMethod, float amount) {
        this.date = date;
        this.customer = customer;
        this.product = product;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public Date getDate() {
        return this.date;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) { this.customer = customer; }

    public ArrayList<Product> getProduct() {
        return this.product;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public float getAmount() { return this.amount; }

    public void setAmount(float amount) { this.amount = amount; }
}
