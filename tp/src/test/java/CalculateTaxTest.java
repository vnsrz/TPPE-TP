import Sale.SaleService;
import customer.Customer;
import customer.CustomerType;
import indicator.RegionType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculateTaxTest {

    SaleService saleService;
    @Before
    public void setup () {
        saleService = new SaleService();
    }

    @Test
    public void testCalculateTax() {
        Customer customer1 = new Customer("Henrique", CustomerType.SPECIAL, RegionType.NORTE,false);
        Assert.assertEquals(saleService.calculateTax(), 12,0);
    }

}
