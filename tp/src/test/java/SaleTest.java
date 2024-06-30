import Sale.Sale;
import customer.Customer;
import customer.CustomerType;
import org.junit.Assert;
import org.junit.Test;
import product.Product;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class SaleTest {

    @Test
    public void testGetSaleDate() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Bicicleta",300,"unidade"));
        products.add(new Product(2,"Camisa",50,"unidade"));
        Customer costumer = new Customer("Julia", CustomerType.STANDARD, "GO",false);
        Sale sale = new Sale(Date.from(Instant.parse("2019-12-03T10:15:30.00Z")),costumer, products, "1234567890123456");
        Assert.assertEquals(sale.getDate(), Date.from(Instant.parse("2019-12-03T10:15:30.00Z")));
    }

    @Test
    public void testGetDifferentSaleDate() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Bicicleta",300,"unidade"));
        products.add(new Product(2,"Camisa",50,"unidade"));
        Customer costumer = new Customer("Julia", CustomerType.STANDARD, "GO",false);
        Sale sale = new Sale(Date.from(Instant.parse("2024-12-14T10:15:30.00Z")), costumer, products,"1234567890123456");
        Assert.assertEquals(sale.getDate(), Date.from(Instant.parse("2024-12-14T10:15:30.00Z")));
    }
    @Test
    public void testGetCustomer() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Bicicleta",300,"unidade"));
        products.add(new Product(2,"Camisa",50,"unidade"));
        Customer costumer = new Customer("Julia", CustomerType.STANDARD, "GO",false);
        Sale sale = new Sale(Date.from(Instant.now()), costumer, products, "1234567890123456");
        Assert.assertEquals(sale.getCustomer(), costumer);

    }

    @Test
    public void testGetCustomerPrime() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Bicicleta",300,"unidade"));
        products.add(new Product(2,"Camisa",50,"unidade"));
        Customer costumer = new Customer("Julia", CustomerType.PRIME, "GO",false);
        Sale sale = new Sale(Date.from(Instant.now()), costumer, products, "1234567890123456");
        Assert.assertEquals(sale.getCustomer(), costumer);
    }

    @Test
    public void testGetProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Bicicleta",300,"unidade"));
        products.add(new Product(2,"Camisa",50,"unidade"));

        Customer costumer = new Customer("Julia", CustomerType.PRIME, "GO",false);
        Sale sale = new Sale(Date.from(Instant.now()), costumer,products, "1234567890123456");
        Assert.assertEquals(sale.getProduct(), products);
    }

    @Test
    public void testGetProduct() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Bicicleta",300,"unidade"));

        Customer costumer = new Customer("Julia", CustomerType.PRIME, "GO",false);
        Sale sale = new Sale(Date.from(Instant.now()), costumer,products, "1234567890123456");
        Assert.assertEquals(sale.getProduct(), products);
    }

    @Test
    public void testGetPaymentMethod() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Bicicleta",300,"unidade"));
        products.add(new Product(2,"Camisa",50,"unidade"));

        Customer costumer = new Customer("Julia", CustomerType.PRIME, "GO",false);
        Sale sale = new Sale(Date.from(Instant.now()), costumer,products, "1234567890123456");
        Assert.assertEquals(sale.getPaymentMethod(), "1234567890123456");
    }

    @Test
    public void testGetDifferentPaymentMethod() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Bicicleta",300,"unidade"));
        products.add(new Product(2,"Camisa",50,"unidade"));

        Customer costumer = new Customer("Julia", CustomerType.PRIME, "GO",false);
        Sale sale = new Sale(Date.from(Instant.now()), costumer,products, "1234567890123478");
        Assert.assertEquals(sale.getPaymentMethod(), "1234567890123478");
    }




}
