import Sale.*;
import customer.Customer;
import customer.CustomerType;
import indicator.RegionType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import product.Product;

import java.util.ArrayList;

public class ProcessSaleTest {

    SaleService saleService;

    @Before
    public void setup() {
       saleService = new SaleService();
    }

    @Test
    public void testProcessSale() {
        Customer customer = new Customer("Vitor", CustomerType.SPECIAL, RegionType.CENTRO_OESTE,false);
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Bola de praia", 15.5, "unidade"));
        products.add(new Product(2, "Bastão de cola", 5, "unidade"));


        Assert.assertEquals(saleService.processSale(customer, products, "19203930291029283"),  29.6f, 0.01);
    }

    @Test
    public void testProcessSalePriceProducts() {
        Customer customer = new Customer("Vitor", CustomerType.PRIME, RegionType.CENTRO_OESTE,false);
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Bola de praia", 20.5, "unidade"));
        products.add(new Product(2, "Bastão de cola", 5, "unidade"));


        Assert.assertEquals(saleService.processSale(customer, products, "19203930291029283"),  25.5f, 0.01);
    }

    @Test
    public void testProcessSaleDifferentPriceProducts() {
        Customer customer = new Customer("Vitor", CustomerType.PRIME, RegionType.CENTRO_OESTE,false);
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Bola de praia", 22.5, "unidade"));
        products.add(new Product(2, "Bastão de cola", 5, "unidade"));


        Assert.assertEquals(saleService.processSale(customer, products, "19203930291029283"),  27.5f, 0.01);
    }

    @Test
    public void testProcessSaleWithShipping() {
        Customer customer = new Customer("Vitor", CustomerType.STANDARD, RegionType.CENTRO_OESTE,false);
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Bola de praia", 22.5, "unidade"));
        products.add(new Product(2, "Bastão de cola", 5, "unidade"));


        Assert.assertEquals(saleService.processSale(customer, products, "19203930291029283"),  40.5f, 0.01);
    }

}
