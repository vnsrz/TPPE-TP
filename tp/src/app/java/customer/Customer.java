package customer;

import java.util.List;
import sales.Sale;

import java.time.LocalDate;
import java.util.ArrayList;

public class Customer {
    private String name;
    private CustomerType type;
    private String state;
    private boolean isCapital;
    private final List<Sale> sales;

    public Customer(String name, CustomerType type, String state, boolean isCapital) {
        this.name = name;
        this.type = type;
        this.state = state;
        this.isCapital = isCapital;
        this.sales = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public CustomerType getType() {
        return this.type;
    }

    public String getState() {
        return this.state;
    }

    public boolean isCapital() {
        return this.isCapital;
    }
    public void addSale(Sale sale) {
        sales.add(sale);
    }
     public double getSalesLastMonth() {
        LocalDate now = LocalDate.now();
        LocalDate oneMonthAgo = now.minusMonths(1);
        return sales.stream()
                .filter(sale -> sale.getDate().isAfter(oneMonthAgo) && sale.getDate().isBefore(now))
                .mapToDouble(Sale::getAmount)
                .sum();
    }

    public boolean isEligibleForSpecial() {
        return getSalesLastMonth() > 1000.0; // Critério de exemplo para ser especial
    }
}
