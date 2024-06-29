import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import customer.Customer;
import customer.CustomerType;
import sales.Sale;

@RunWith(Parameterized.class)
public class CustomerSpecialStatusTest {
    private Customer customer;
    private double salesAmount;
    private boolean expectedEligibility;

    public CustomerSpecialStatusTest(double salesAmount, boolean expectedEligibility) {
        this.salesAmount = salesAmount;
        this.expectedEligibility = expectedEligibility;
    }

    @Before
    public void setUp() {
        customer = new Customer("Test Customer", CustomerType.STANDARD, "Test State", false);
        customer.addSale(new Sale(salesAmount, LocalDate.now().minusDays(10)));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { 500.0, false },    // Cliente não elegível (valor menor que o limite)
            { 1000.0, false },   // Cliente não elegível (valor igual ao limite)
            { 1500.0, true },    // Cliente elegível (valor acima do limite)
            { 2000.0, true }     // Cliente elegível (valor acima do limite)
        });
    }

    @Test
    public void testIsEligibleForSpecial() {
        assertEquals(expectedEligibility, customer.isEligibleForSpecial());
    }
}

