import Sale.Sale;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;

public class SaleTest {

    @Test
    public void testGetSaleDate() {
        Sale sale = new Sale(Date.from(Instant.parse("2019-12-03T10:15:30.00Z")));
        Assert.assertEquals(sale.getDate(), Date.from(Instant.parse("2019-12-03T10:15:30.00Z")));
    }

    @Test
    public void testGetDifferentSaleDate() {
        Sale sale = new Sale(Date.from(Instant.parse("2024-12-14T10:15:30.00Z")));
        Assert.assertEquals(sale.getDate(), Date.from(Instant.parse("2024-12-14T10:15:30.00Z")));
    }

}
