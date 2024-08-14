import Sale.PaymentDetails;
import Sale.SaleService;
import Sale.SaleTransaction;
import customer.Customer;
import customer.CustomerType;
import indicator.RegionType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import product.Product;

import java.util.Date;
import java.time.Instant;
import java.util.ArrayList;


@RunWith(Parameterized.class)
public class AddSaleTest {

    SaleService saleService;
    Object[] sales;
    Object sale;


    public AddSaleTest(Object[] sales, Object sale) {
        this.sales = sales;
        this.sale = sale;
    }

    @Before
    public void setup() {
        saleService = new SaleService();
    }


    @Parameters
    public static Object[][] getParameters() {
        ArrayList<Product> productsA = new ArrayList<>();
        productsA.add(new Product(1, "Bicicleta",300,"unidade"));
        Customer customerA = new Customer("Juliana", CustomerType.STANDARD, RegionType.SUDESTE,false);
        SaleTransaction saleA = new SaleTransaction(Date.from(Instant.now()), customerA, productsA, new PaymentDetails("0234567890123456",300));

        ArrayList<Product> productsB = new ArrayList<>();
        productsB.add(new Product(2,"Camisa",50,"unidade"));
        Customer customerB = new Customer("Adriano", CustomerType.STANDARD, RegionType.DISTRITO_FEDERAL,false);
        SaleTransaction saleB = new SaleTransaction(Date.from(Instant.now()), customerB, productsB, new PaymentDetails("0234567890123456",300));

        ArrayList<Product> productsC = new ArrayList<>();
        productsB.add(new Product(2,"Camisa",50,"unidade"));
        Customer customerC = new Customer("Adriano", CustomerType.STANDARD, RegionType.NORTE,false);
        SaleTransaction saleC = new SaleTransaction(Date.from(Instant.now()), customerC, productsC, new PaymentDetails("0234567890123456", 300));
        return new Object[][] {
                {
                    new Object[] {saleA},
                        saleA
                },
                {
                    new Object[] {saleA,saleB},
                        saleB
                },
                {
                    new Object[] {saleA, saleB, saleC},
                        saleC
                }
        };

    }

    @Test
    public void testAddSale() {
        for(Object sale : sales) {
            saleService.addSale((SaleTransaction) sale);
        }

        Assert.assertTrue(saleService.getSales().contains(sale));
    }





}
