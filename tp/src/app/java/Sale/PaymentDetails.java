package Sale;

public class PaymentDetails {
    private final String paymentMethod;
    private final float amount;
    private float discount;
    private float tax;
    private float shipping;

    public PaymentDetails(String paymentMethod, float amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public float getAmount() {
        return this.amount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getDiscount() {
        return this.discount;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getTax() {
        return this.tax;
    }

    public void setShipping(float shipping) {
        this.shipping = shipping;
    }

    public float getShipping() {
        return this.shipping;
    }
}
