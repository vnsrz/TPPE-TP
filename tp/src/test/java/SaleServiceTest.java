import Sale.Sale;
import Sale.SaleService;
import customer.Customer;
import customer.CustomerType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import product.Product;

import java.util.Date;
import java.time.Instant;
import java.util.ArrayList;


// cadastrar venda
// calcular frete
// calcular descontos
// calcular impostos
// calcular cashback

public class SaleServiceTest {

    SaleService saleService;

    @Before
    public void setup() {
        saleService = new SaleService();
    }


    @Test
    public void testAddSale() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Bicicleta",300,"unidade"));
        products.add(new Product(2,"Camisa",50,"unidade"));
        Customer customer = new Customer("Juliana", CustomerType.STANDARD, "Valparaiso",false);
        Sale sale = new Sale(Date.from(Instant.now()), customer, products, "0234567890123456");

        saleService.addSale(sale);

        Assert.assertEquals(saleService.getSale(sale), sale);
    }

}
