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
        switch (region) {
            case CENTRO_OESTE: return 10;
            case NORTE: return 20;
            case NORDESTE: return 15;
            case SUL: return 10;
            case DISTRITO_FEDERAL: return 5;
            case SUDESTE: return 7;
            default: return 0;
        }
    }
}
