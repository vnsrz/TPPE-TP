import Sale.SaleService;
import customer.Customer;
import customer.CustomerType;
import indicator.RegionType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculateShippingTest {

    SaleService saleService;

    Customer customer;
    int shippingResult;

    public CalculateShippingTest(Customer customer, int shippingResult) {
        this.customer = customer;
        this.shippingResult = shippingResult;
    }

    @Before
    public void Setup() {
        saleService = new SaleService();
    }

    @Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                { new Customer("Juliana", CustomerType.STANDARD, RegionType.CENTRO_OESTE,true), 10},
                { new Customer("Juliana", CustomerType.STANDARD, RegionType.CENTRO_OESTE,false), 13},
                { new Customer("Henrique", CustomerType.PRIME, RegionType.NORTE,false), 25},
                { new Customer("Henrique", CustomerType.PRIME, RegionType.NORTE,true), 20},
                { new Customer("Andre", CustomerType.SPECIAL, RegionType.SUL, true), 10},
                { new Customer("Andre", CustomerType.SPECIAL, RegionType.SUL, false), 13},
                { new Customer("Maria", CustomerType.SPECIAL, RegionType.NORDESTE, true), 15},
                { new Customer("Maria", CustomerType.SPECIAL, RegionType.NORDESTE, false), 18},
                { new Customer("Henrique", CustomerType.SPECIAL, RegionType.SUDESTE,true), 7},
                { new Customer("Henrique", CustomerType.SPECIAL, RegionType.SUDESTE,false), 10},
                { new Customer("Henrique", CustomerType.SPECIAL, RegionType.NORTE,false), 25},
                { new Customer("Henrique", CustomerType.SPECIAL, RegionType.SUDESTE, false), 10},
                { new Customer("Joao", CustomerType.SPECIAL, RegionType.DISTRITO_FEDERAL,true), 5},
                { new Customer("Joao", CustomerType.SPECIAL, RegionType.DISTRITO_FEDERAL,false), 5},
        };
    }

    @Test
    public void testCalculateShipping() {
        Assert.assertEquals(saleService.calculateShipping(customer.getState(),customer.isCapital()), shippingResult);
    }


}
