//superclass implements subclass
public class ProductCalculations implements IProductCalculations {

    private double price;

    // Constructor - we pass the price in from the GUI
    public ProductCalculations(double price) {
        this.price = price;
    }

    @Override
    public double GetVat() {
        return price * 0.15; // 15% of price
    }

    @Override
    public double GetCommission() {
        return price * 0.05; // 5% of price
    }

    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission(); // Price + VAT + Commission
    }
}