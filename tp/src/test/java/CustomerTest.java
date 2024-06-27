package customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CustomerTest {

    private String testName;
    private CustomerType testType;
    private String testState;
    private boolean testIsCapital;

    public CustomerTest(String testName, CustomerType testType, String testState, boolean testIsCapital) {
        this.testName = testName;
        this.testType = testType;
        this.testState = testState;
        this.testIsCapital = testIsCapital;
    }

    @Parameters(name = "{index}: Customer({0}, {1}, {2}, {3})")
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][] {
                {"Joao", CustomerType.STANDARD, "Brasilia", true},
                {"Maria", CustomerType.STANDARD, "Gama", true},
                {"Carlos", CustomerType.SPECIAL, "Recanto", true},
                {"Jessica", CustomerType.PRIME, "Taguatinga", true},
                {"Pedro", CustomerType.STANDARD, "Lago Sul", true},
                {"Leandro", CustomerType.STANDARD, "Sobradinho", true},
                {"Jao", CustomerType.STANDARD, "Ceilandia", true},
                {"Joao", CustomerType.STANDARD, "Paranoa", false}
        });
    }

    @Test
    public void testCustomer() {
        Customer customer = new Customer(testName, testType, testState, testIsCapital);

        assertEquals(testName, customer.getName());
        assertEquals(testType, customer.getType());
        assertEquals(testState, customer.getState());
        assertEquals(testIsCapital, customer.isCapital());
    }
}
