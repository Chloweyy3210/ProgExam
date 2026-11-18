import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductCalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500);
        // 15% of 3500 = 525
        assertEquals(525.0, calc.GetVat(), 0.01);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500);
        // 3500 + 525 + 175 = 4200
        assertEquals(4200.0, calc.GetTotal(), 0.01);
    }

    //  good to add for Commission
    @Test
    public void GetCommission_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calc = new ProductCalculations(3500);
        // 5% of 3500 = 175
        assertEquals(175.0, calc.GetCommission(), 0.01);
    }
}