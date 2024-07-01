package Sale;

import customer.CustomerType;
import indicator.RegionType;

import java.util.ArrayList;

public class SaleService {

    private ArrayList<Sale> sales;

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
}
