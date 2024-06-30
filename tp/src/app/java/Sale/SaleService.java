package Sale;

import java.util.ArrayList;

public class SaleService {

    private Sale sales;

    public void addSale(Sale sale) {
        this.sales = sale;
    }

    public Sale getSales() {
        return this.sales;
    }
}
