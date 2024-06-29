import product.Product;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    @Test
    public void testCreateProductCode() {
        Product product = new Product(1, "Bola de praia", 15.5, "unidade");
        assertEquals(1, product.getCode());
    }

    @Test
    public void testCreateProductDescription() {
        Product product = new Product(2, "Bastão de cola", 5, "unidade");
        assertEquals("Bastão de cola", product.getDescription());
    }

    @Test
    public void testCreateProductPrice() {
        Product product = new Product(3, "Tecido azul", 9.99, "metro");
        assertEquals(9.99, product.getPrice());
    }
}