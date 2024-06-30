import Sale.SaleService;
import customer.Customer;
import customer.CustomerType;
import indicator.RegionType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class calculateShippingTest {

    SaleService saleService;

    @Before
    public void Setup() {
        saleService = new SaleService();
    }

    @Test
    public void testCalculateShipping() {
        Customer customerA = new Customer("Juliana", CustomerType.STANDARD, RegionType.CENTRO_OESTE,false);

        Assert.assertEquals(saleService.calculateShipping(customerA.getState()), 10);

    }
    @Test
    public void testCalculateShippingOtherRegion() {
        Customer customerA = new Customer("Henrique", CustomerType.PRIME, RegionType.NORTE,false);

        Assert.assertEquals(saleService.calculateShipping(customerA.getState()), 20);

    }
}
