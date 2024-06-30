import Sale.Sale;
import Sale.SaleService;
import customer.Customer;
import customer.CustomerType;
import indicator.RegionType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import product.Product;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class calculateShippingTest {

    SaleService saleService;

    @Before
    public void Setup() {
        saleService = new SaleService();
    }

    @Test
    public void testCalculateShipping() {
        ArrayList<Product> productsA = new ArrayList<>();
        productsA.add(new Product(1, "Bicicleta",300,"unidade"));
        Customer customerA = new Customer("Juliana", CustomerType.STANDARD, RegionType.CENTRO_OESTE,false);
        Sale saleA = new Sale(Date.from(Instant.now()), customerA, productsA, "0234567890123456");

        Assert.assertEquals(saleService.calculateShipping(saleA), 10);

    }
}
