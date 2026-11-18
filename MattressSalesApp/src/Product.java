public class Product implements IProduct {

    // 1D array - product names (single-dimensional array)
    private String[] productNames;

    // 2D array - [3 products][3 months] (two-dimensional array)
    private int[][] sales;

    // Constructor - we pass the data in from Main
    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total = total + sales[i][j];
            }
        }
        return total; // 153
    }

    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int count = 0;
        for (int i = 0; i < sales.length; i++) {
            count = count + sales[i].length; // 3 x 3 = 9
        }
        return (double) total / count; // 153 / 9 = 17.0
    }

    @Override
    public String GetMostPopularProduct() {
        // Find the highest single sale and which product it belongs to
        int maxSale = sales[0][0];
        int maxProductIndex = 0;

        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                if (sales[i][j] > maxSale) {
                    maxSale = sales[i][j];
                    maxProductIndex = i;
                }
            }
        }
        // Return exactly like the screenshot: Cozy Nights Monarch (25)
        return productNames[maxProductIndex] + " (" + maxSale + ")";
    }
}