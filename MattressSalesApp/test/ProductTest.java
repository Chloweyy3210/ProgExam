import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    // Same data as the screenshot
    String[] names = {
        "Cozy Nights Monarch",
        "Restonic Barbados",
        "Sealy Phuket"
    };

    int[][] sales = {
        {25, 18, 20},
        {15, 10, 12},
        {18, 15, 20}
    };

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(names, sales);
        assertEquals(153, product.GetTotalProductsSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(names, sales);
        assertEquals(17.0, product.GetAverageProductSold(), 0.01);
    }

    // Extra - good to add for Most Popular
    @Test
    public void GetMostPopularProduct_WithValidData_ReturnsCorrectValue() {
        Product product = new Product(names, sales);
        assertEquals("Cozy Nights Monarch (25)", product.GetMostPopularProduct());
    }
}