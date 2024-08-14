package Sale;

import customer.Customer;
import customer.CustomerType;
import indicator.RegionType;
import product.Product;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class SaleService {

    private ArrayList<Sale> sales;

    private final String STORE_CREDIT_CARD = "429613";

    public SaleService() {
        this.sales = new ArrayList<>();
    }


    public void addSale(Sale sale) {
        this.sales.add(sale);
    }

    public ArrayList<Sale> getSales() {
        return this.sales;
    }

    public float calculateShipping(RegionType region, boolean isCapital, CustomerType customerType) {
        if(customerType.name().equals(CustomerType.PRIME.name())) return 0;

        float shippingPrice;

        switch (region) {
            case CENTRO_OESTE, SUL:
                shippingPrice = isCapital ? 10 : 13;
                break;
            case NORTE:
                shippingPrice = isCapital? 20 : 25;
                break;
            case NORDESTE:
                shippingPrice = isCapital ? 15 : 18;
                break;
            case DISTRITO_FEDERAL:
                shippingPrice = 5;
                break;
            case SUDESTE:
                shippingPrice = isCapital ? 7 : 10;
                break;
            default:
                shippingPrice = 0;
        }

        return isSpecial(customerType) ? shippingPrice * 0.7f : shippingPrice;
    }

    private Boolean isSpecial(CustomerType customerType) { return CustomerType.SPECIAL.name().equals(customerType.name()); }

    public float calculateTax(RegionType regionType, float amount) {
        return RegionType.DISTRITO_FEDERAL.name().equals(regionType.name()) ? (amount * 0.18f) : (amount * 0.16f) ;
    }

    public float calculateDiscount(CustomerType customerType, float amount, String paymentCard) {
        float discount = 0;

        if (CustomerType.SPECIAL.name().equals(customerType.name())) discount = amount * 0.1f;

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
        return new SaleProcessor(customer, products, paymentMethod, this).processSale();
    }
}
