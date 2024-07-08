package Sale;

import customer.Customer;
import product.Product;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class Sale {
    private Date date;
    private Customer customer;
    private ArrayList<Product> product;
    private String paymentMethod;
    private float amount;
    private float discount;
    private float tax;
    private float shipping;
    private float cashback;

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

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getShipping() {
        return shipping;
    }

    public void setShipping(float shipping) {
        this.shipping = shipping;
    }

    public ArrayList<Product> getProduct() {
        return this.product;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public float getAmount() { return this.amount; }

    public void setAmount(float amount) { this.amount = amount; }

    public float getCashback() { return cashback; } 

    public void setCashback(float cashback) { this.cashback = cashback; }

    @Override
    public String toString() {

        String products = this.getProduct().stream().map(p -> p.toString()).reduce("", String::concat);

        return "DATE: " + this.date + " | " +
                "CLIENTE: " + this.customer.getName() + "-" + this.customer.getType().name() + "-" + this.customer.getState().name() + " | " +
                "\nPRODUTOS: \n" + products + " | " +
                "VALOR TOTAL: " + this.amount + "\n" +
                "Imposto: " + this.tax + "\n" +
                "Desconto: " + this.discount + "\n" +
                "Frete: " + this.shipping;

    }
}
