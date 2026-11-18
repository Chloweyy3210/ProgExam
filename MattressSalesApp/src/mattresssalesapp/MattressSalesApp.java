import java.util.Scanner;

public class MattressSalesApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1D array - product names
        String[] productNames = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        // 2D array - [3 products][3 months]
        int[][] sales = new int[3][3];

        // Ask user for every product, every month
        for (int i = 0; i < productNames.length; i++) {
            for (int month = 1; month <= 3; month++) {
                System.out.print("Enter number of sales for month " + month
                        + " for " + productNames[i] + " mattress: ");
                sales[i][month - 1] = input.nextInt();
            }
            System.out.println(); //printing blank line
        }

        // Create the Product object with the data
        Product product = new Product(productNames, sales);

        // Create the Print object to print the report
        PrintProduct printer = new PrintProduct();

        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("******************************************");
        printer.printTotalProductSales(product);
        printer.printAverageProductSales(product);
        printer.printMostPopularProduct(product);

        input.close();
    }
}