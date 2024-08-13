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

    private float calculateCustomerDiscount(CustomerType customerType, float amount) {
        if (customerType == CustomerType.SPECIAL) {
            return amount * 0.1f;
        }
        return 0;
    }

    private float calculateCardDiscount(String paymentCard, float amount) {
        if (paymentCard != null && paymentCard.startsWith(STORE_CREDIT_CARD)) {
            return amount * 0.1f;
        }
        return 0;
    }

    public float calculateDiscount(CustomerType customerType, float amount, String paymentCard) {
        float discount = 0;

        discount += calculateCustomerDiscount(customerType, amount);
        discount += calculateCardDiscount(paymentCard, amount);

        return discount;
    }
    /* 
    Ao extrair a lógica de cálculo de desconto com base no tipo de cliente e no cartão de pagamento em métodos separados, 
    estamos aplicando o princípio da responsabilidade única. Isso faz com que o código seja mais modular, 
    permitindo que cada parte seja entendida, desenvolvida e modificada de maneira independente, 
    além de melhorar a legibilidade do código, proporcionando uma base sólida para futuras expansões no sistema.
    */

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
            amount+= p.getPrice();
        }

        float discount = calculateDiscount(customer.getType(), amount, paymentMethod);
        amount -= discount;
        float tax  = calculateTax(customer.getState(), amount);
        float shipping = calculateShipping(customer.getState(), customer.isCapital(), customer.getType());
        amount += tax + shipping;

        float cashback = calculateCashback(customer, amount, paymentMethod);

        Sale sale = new Sale(Date.from(Instant.now()), customer, products, paymentMethod, amount);
        sale.setDiscount(discount);
        sale.setTax(tax);
        sale.setShipping(shipping);
        sale.setCashback(cashback);

        this.addSale(sale);

        System.out.println(sale);
        if (cashback > 0) {
            System.out.printf("Cashback recebido: R$ %.2f%n", cashback); 
        }

        return amount;
    }
}
