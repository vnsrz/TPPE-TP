import product.Product;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    @Test
    public void testCreateProduct() {
        Product product = new Product(1, "Bola de praia", 15.5, "unidade");
        assertEquals(1, product.getCode());
    }
}