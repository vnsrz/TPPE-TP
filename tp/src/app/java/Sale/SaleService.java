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

    public int calculateShipping(RegionType region, boolean isCapital, CustomerType customerType) {
        if(customerType.name().equals(CustomerType.PRIME.name())) return 0;

        switch (region) {
            case CENTRO_OESTE, SUL: return isCapital ? 10 : 13;
            case NORTE: return isCapital? 20 : 25;
            case NORDESTE: return isCapital ? 15 : 18;
            case DISTRITO_FEDERAL: return 5;
            case SUDESTE: return isCapital ? 7 : 10;
            default: return 0;
        }
    }

    public float calculateTax(RegionType regionType, float amount) {
        return RegionType.DISTRITO_FEDERAL.name().equals(regionType.name()) ? (amount * 0.18f) : (amount * 0.16f) ;
    }
}
