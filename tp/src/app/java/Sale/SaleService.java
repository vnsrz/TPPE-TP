package Sale;

import customer.Customer;
import customer.CustomerType;
import indicator.RegionType;
import product.Product;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class SaleService {

    private final ArrayList<SaleTransaction> sales;

    private final String STORE_CREDIT_CARD = "429613";

    public SaleService() {
        this.sales = new ArrayList<>();
    }

    public void addSale(SaleTransaction sale) {
        this.sales.add(sale);
    }

    public ArrayList<SaleTransaction> getSales() {
        return this.sales;
    }

    public float calculateShipping(RegionType region, boolean isCapital, CustomerType customerType) {
        if(customerType.name().equals(CustomerType.PRIME.name())) return 0;

        float shippingPrice = switch (region) {
            case CENTRO_OESTE, SUL -> isCapital ? 10 : 13;
            case NORTE -> isCapital ? 20 : 25;
            case NORDESTE -> isCapital ? 15 : 18;
            case DISTRITO_FEDERAL -> 5;
            case SUDESTE -> isCapital ? 7 : 10;
            default -> 0;
        };

        return isSpecial(customerType) ? shippingPrice * 0.7f : shippingPrice;
    }

    private Boolean isSpecial(CustomerType customerType) {
        return CustomerType.SPECIAL.name().equals(customerType.name());
    }

    public float calculateTax(RegionType regionType, float amount) {
        return RegionType.DISTRITO_FEDERAL.name().equals(regionType.name()) ? (amount * 0.18f) : (amount * 0.16f);
    }

    public float calculateDiscount(CustomerType customerType, float amount, String paymentCard) {
        float discount = 0;

        if (CustomerType.SPECIAL.name().equals(customerType.name())) {
            discount = amount * 0.1f;
        }

        discount += paymentCard.startsWith(STORE_CREDIT_CARD) ? amount * 0.1f : 0;

        return discount;
    }

    public float calculateCashback(Customer customer, float amount, String paymentCard) {
        if (!CustomerType.PRIME.equals(customer.getType())) {
            return 0;
        }

        float cashbackPerReal = paymentCard.startsWith(STORE_CREDIT_CARD) ? 0.05f : 0.03f;
        return amount * cashbackPerReal;
    }

    public float processSale(Customer customer, ArrayList<Product> products, String paymentMethod) {
        float amount = 0;

        for(Product p : products){
            amount += (float) p.getPrice();
        }

        float discount = calculateDiscount(customer.getType(), amount, paymentMethod);
        amount -= discount;
        float tax = calculateTax(customer.getState(), amount);
        float shipping = calculateShipping(customer.getState(), customer.isCapital(), customer.getType());
        amount += tax + shipping;

        float cashback = calculateCashback(customer, amount, paymentMethod);

        PaymentDetails paymentDetails = new PaymentDetails(paymentMethod, amount);
        paymentDetails.setDiscount(discount);
        paymentDetails.setTax(tax);
        paymentDetails.setShipping(shipping);

        SaleTransaction sale = new SaleTransaction(Date.from(Instant.now()), customer, products, paymentDetails);

        this.addSale(sale);

        System.out.println(sale);
        if (cashback > 0) {
            System.out.printf("Cashback recebido: R$ %.2f%n", cashback);
        }

        return amount;
    }
}
