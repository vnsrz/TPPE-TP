package Sale;

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

    public int calculateShipping(RegionType region) {
        return RegionType.CENTRO_OESTE.name().equals(region.name()) ? 10 : 20;
    }
}
