package Sale;

import customer.Customer;
import product.Product;

import java.util.ArrayList;
import java.util.Date;

public class SaleTransaction {
    private final Date date;
    private Customer customer;
    private final ArrayList<Product> products;
    private final PaymentDetails paymentDetails;

    public SaleTransaction(Date date, Customer customer, ArrayList<Product> products, PaymentDetails paymentDetails) {
        this.date = date;
        this.customer = customer;
        this.products = products;
        this.paymentDetails = paymentDetails;
    }

    public Date getDate() {
        return this.date;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public PaymentDetails getPaymentDetails() {
        return this.paymentDetails;
    }

    @Override
    public String toString() {
        return SaleFormatter.format(this);
    }
}
