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

    @Test
    public void testCreateCustomerWithDifferentName() {
        Customer customer = new Customer("Maria", CustomerType.STANDARD, "Gama", true);
        assertEquals("Maria", customer.getName());
    }

    @Test
    public void testCreateCustomerWithType() {
        Customer customer = new Customer("Carlos", CustomerType.SPECIAL, "Recanto", true);
        assertEquals(CustomerType.SPECIAL, customer.getType());
    }

    @Test
    public void testCreateCustomerWithDifferentType() {
        Customer customer = new Customer("Jessica", CustomerType.PRIME, "Taguatinga", true);
        assertEquals(CustomerType.PRIME, customer.getType());
    }

    @Test
    public void testCustomerState() {
        Customer customer = new Customer("Pedro", CustomerType.STANDARD, "Lago Sul", true);
        assertEquals("Lago Sul", customer.getState());
    }

    @Test
    public void testCustomerWithDifferentState() {
        Customer customer = new Customer("Leandro", CustomerType.STANDARD, "Sobradinho", true);
        assertEquals("Sobradinho", customer.getState());
    }

    @Test
    public void testCustomerIsCapital() {
        Customer customer = new Customer("Jao", CustomerType.STANDARD, "Ceilandia", true);
        assertTrue(customer.isCapital());
    }

    @Test
    public void testCustomerIsNotCapital() {
        Customer customer = new Customer("Joao", CustomerType.STANDARD, "Paronoa", false);
        assertFalse(customer.isCapital());
    }
}