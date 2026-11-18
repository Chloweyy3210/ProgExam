// for printing data in the report
public class PrintProduct {

    //shows the TOTAL PRODUCT SALES
    public void printTotalProductSales(Product product) {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void printAverageProductSales(Product product) {
        // Show average as whole number like in screenshot
        System.out.println("AVERAGE PRODUCT SALES: " + (int) product.GetAverageProductSold());
    }
       //shows the most popular product
    public void printMostPopularProduct(Product product) {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}