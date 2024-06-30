package Sale;

import customer.Customer;
import product.Product;

import java.util.ArrayList;
import java.util.Date;

public class Sale {
    private Date date;
    private Customer customer;
    private ArrayList<Product> product;
    private String paymentMethod;

    public Sale(Date date, Customer customer, ArrayList<Product> product, String paymentMethod) {
        this.date = date;
        this.customer = customer;
        this.product = product;
        this.paymentMethod = paymentMethod;
    }

    public Date getDate() {
        return this.date;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public ArrayList<Product> getProduct() {
        return this.product;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

}
