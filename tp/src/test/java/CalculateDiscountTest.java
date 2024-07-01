import Sale.SaleService;
import customer.CustomerType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculateDiscountTest {

    SaleService saleService;
    @Before
    public void setup() {
        saleService = new SaleService();
    }
    @Test
    public void testCalculateDiscount() {
        Assert.assertEquals(saleService.calculateDiscount(CustomerType.SPECIAL,3000f), 300f, 0.01);
    }

    @Test
    public void testCalculateDiscountNoSpecial() {
        Assert.assertEquals(saleService.calculateDiscount(CustomerType.STANDARD,3000f), 0, 0.01);
    }


}
