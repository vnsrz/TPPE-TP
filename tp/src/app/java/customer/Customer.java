package customer;

public class Customer {
    private String name;
    private CustomerType type;
    private String state;
    private boolean isCapital;

    public Customer(String name, CustomerType type, String state, boolean isCapital) {
        this.name = name;
        this.type = type;
        this.state = state;
        this.isCapital = isCapital;
    }

    public String getName() {
        return this.name;
    }
}