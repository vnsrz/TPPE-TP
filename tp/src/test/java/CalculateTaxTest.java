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
        Assert.assertEquals(saleService.calculateTax(customer1.getState(),5000f), 800f,0);
    }

    @Test
    public void testCalculateDifferentTax() {
        Customer customer1 = new Customer("Henrique", CustomerType.SPECIAL, RegionType.DISTRITO_FEDERAL,false);
        Assert.assertEquals(saleService.calculateTax(customer1.getState(), 10000f), 1800f,0.01);
    }

}
