import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

//superclass implements subclass
public class ProductApp extends JFrame {

    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    public ProductApp() {
        setTitle("Product App");
        setSize(420, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centre on screen
        setLayout(new GridLayout(4, 2, 10, 10));

        // Q.2.2: Text box for Customer Name
        add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        add(txtCustomerName);

        // Q.2.2: Combo box for Product Name
        add(new JLabel("Select Product:"));
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        add(cmbProduct);

        //  Q.2.2: Text box for Price 
        add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        add(txtPrice);

        // Empty label to push button to the right like screenshot
        add(new JLabel(""));

        // Q.2.3: Process Button
        btnProcess = new JButton("PROCESS");
        add(btnProcess);

        // Q.2.4: Menu System
        JMenuBar menuBar = new JMenuBar();

        JMenu mnuFile = new JMenu("File");
        JMenuItem mnuExit = new JMenuItem("Exit");

        JMenu mnuTools = new JMenu("Tools");
        JMenuItem mnuProcess = new JMenuItem("Process");
        JMenuItem mnuClear = new JMenuItem("Clear");

        mnuFile.add(mnuExit);
        mnuTools.add(mnuProcess);
        mnuTools.add(mnuClear);
        menuBar.add(mnuFile);
        menuBar.add(mnuTools);
        setJMenuBar(menuBar);

        // ACTIONS 
        // Button and Menu call the SAME method
        btnProcess.addActionListener(e -> processData());
        mnuProcess.addActionListener(e -> processData());

        mnuExit.addActionListener(e -> System.exit(0));

        mnuClear.addActionListener(e -> {
            txtCustomerName.setText("");
            txtPrice.setText("");
            cmbProduct.setSelectedIndex(0); // Back to first product
        });
    }

    // Process - Q.2.3
    private void processData() {
        try {
            String customerName = txtCustomerName.getText();
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            if (customerName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter customer name!");
                return;
            }
           //calculations
            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Show Message dialog 
            String message = "Customer Name: " + customerName + "\n"
                    + "Product: " + productName + "\n"
                    + "VAT: R " + vat + "\n"
                    + "COMMISSION: R " + commission + "\n"
                    + "TOTAL: R " + total;
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save to data.txt - Q.2.3
            FileWriter writer = new FileWriter("data.txt");
            writer.write("DATA LOG\n");
            writer.write("********************************\n");
            writer.write("Customer Name: " + customerName + "\n");
            writer.write("Product: " + productName + "\n");
            writer.write("VAT: R " + vat + "\n");
            writer.write("COMMISSION: R " + commission + "\n");
            writer.write("TOTAL: R " + total + "\n");
            writer.write("********************************\n");
            writer.close();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price number!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductApp().setVisible(true);
        });
    }
}