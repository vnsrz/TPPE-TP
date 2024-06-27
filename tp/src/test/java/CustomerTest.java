import customer.Customer;
import customer.CustomerType;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void testCreateCustomerWithName() {
        Customer customer = new Customer("Joao", CustomerType.STANDARD, "Brasilia", true);
        assertEquals("Joao", customer.getName());
    }
}