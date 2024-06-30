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

        Assert.assertEquals(saleService.calculateShipping(customerA.getState(),customerA.isCapital()), 13);

    }
    @Test
    public void testCalculateShippingOtherRegion() {
        Customer customerA = new Customer("Henrique", CustomerType.PRIME, RegionType.NORTE,false);

        Assert.assertEquals(saleService.calculateShipping(customerA.getState(),customerA.isCapital()), 25);

    }

    @Test
    public void testCalculateShippingSouth() {
        Customer customerA = new Customer("Henrique", CustomerType.SPECIAL, RegionType.SUL,false);

        Assert.assertEquals(saleService.calculateShipping(customerA.getState(),customerA.isCapital()), 13);

    }

    @Test
    public void testCalculateShippingCapital() {
        Customer customerA = new Customer("Henrique", CustomerType.SPECIAL, RegionType.NORDESTE,true);

        Assert.assertEquals(saleService.calculateShipping(customerA.getState(),customerA.isCapital()), 15);
    }

    @Test
    public void testCalculateShippingCapitalOtherRegion() {
        Customer customerA = new Customer("Henrique", CustomerType.SPECIAL, RegionType.SUDESTE,true);

        Assert.assertEquals(saleService.calculateShipping(customerA.getState(),customerA.isCapital()), 7);
    }

    @Test
    public void TestCalculatehippingNotCapital() {
        Customer customerA = new Customer("Henrique", CustomerType.SPECIAL, RegionType.NORTE,false);

        Assert.assertEquals(saleService.calculateShipping(customerA.getState(),customerA.isCapital()), 25);
    }

    @Test
    public void testCalculateShippingNotCapitalOtherRegion() {
        Customer customerA = new Customer("Henrique", CustomerType.SPECIAL, RegionType.SUDESTE,false);

        Assert.assertEquals(saleService.calculateShipping(customerA.getState(),customerA.isCapital()), 10);
    }


}
