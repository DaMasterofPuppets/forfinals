package org.example;

import org.example.Databases.ordersDatabase;
import org.example.Extensions.RoundedButton;
import org.example.Extensions.RoundedTextfield;
import org.example.SidePanels.OrderSidePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderEditorPage {

    public OrderEditorPage(JFrame frame){

        frame.setTitle("Order Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().setBackground(Color.decode("#EF9B39"));
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

        new OrderSidePanel(frame);

        ImageIcon img = new ImageIcon("src/main/java/org/example/img/meal editor.png");
        JLabel imageLabel = new JLabel(img);
        imageLabel.setBounds(235, 50, 500, 500);
        frame.add(imageLabel);

        RoundedButton mealEditor = new RoundedButton("ORDER EDITOR");
        mealEditor.setBounds(650, 50, 365, 90);
        mealEditor.setBackground(Color.decode("#752A00"));
        mealEditor.setFont(new Font("Arial", Font.PLAIN, 35));
        mealEditor.setForeground(Color.decode("#EF9B39"));
        frame.add(mealEditor);

        JLabel label = new JLabel("Hello! What would you like to do?");
        label.setBounds(650, 150, 1000, 100);
        label.setForeground(Color.decode("#752A00"));
        label.setFont(new Font("Arial", Font.PLAIN, 26));
        frame.add(label);

        RoundedButton addOrdersButton = new RoundedButton("Add Order");
        addOrdersButton.setBounds(650, 250, 365, 85);
        addOrdersButton.setBackground(Color.white);
        addOrdersButton.setFont(new Font ("Arial", Font.PLAIN, 32));
        addOrdersButton.setBorderThickness(2);
        addOrdersButton.setBorderColor(Color.decode("#331402"));
        addOrdersButton.setForeground(Color.decode("#551F01"));
        addOrdersButton.setFocusable(false);
        addOrdersButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            addOrdersPage(frame);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(addOrdersButton);

        RoundedButton editOrdersButton = new RoundedButton("Edit Order");
        editOrdersButton.setBounds(650, 350, 365, 85);
        editOrdersButton.setBackground(Color.white);
        editOrdersButton.setFont(new Font ("Arial", Font.PLAIN, 32));
        editOrdersButton.setBorderThickness(2);
        editOrdersButton.setForeground(Color.decode("#551F01"));
        editOrdersButton.setFocusable(false);
        editOrdersButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            editOrdersPage(frame);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(editOrdersButton);

        RoundedButton deleteOrdersButton = new RoundedButton("Delete Order");
        deleteOrdersButton.setBounds(650, 450, 365, 85);
        deleteOrdersButton.setBackground(Color.white);
        deleteOrdersButton.setFont(new Font ("Arial", Font.PLAIN, 32));
        deleteOrdersButton.setBorderThickness(2);
        deleteOrdersButton.setBorderColor(Color.decode("#331402"));
        deleteOrdersButton.setForeground(Color.decode("#551F01"));
        deleteOrdersButton.setFocusable(false);
        deleteOrdersButton.addActionListener(e -> {
            frame.getContentPane().removeAll();
            deleteOrdersPage(frame);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(deleteOrdersButton);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void addOrdersPage(JFrame frame) {
        new OrderSidePanel(frame);

        // Add order label
        JLabel addOrderLabel = new JLabel("ADD ORDER");
        addOrderLabel.setBounds(520, 50, 360, 80);
        addOrderLabel.setOpaque(true);
        addOrderLabel.setBackground(Color.decode("#752A00"));
        addOrderLabel.setForeground(Color.decode("#FACD97"));
        addOrderLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 40));
        addOrderLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(6, 10, 6, 10)
        ));
        addOrderLabel.setHorizontalAlignment(SwingConstants.RIGHT); // Align text to the right
        frame.add(addOrderLabel);

        // Meal name label
        JLabel mealNameLabel = new JLabel("Meal Name");
        mealNameLabel.setBounds(370, 200, 300, 45);
        mealNameLabel.setForeground(Color.decode("#331402"));
        mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(mealNameLabel);

        // Meal name text field
        RoundedTextfield mealNameTf = new RoundedTextfield();
        mealNameTf.setBounds(370, 240, 300, 45);
        mealNameTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        mealNameTf.setBackground(Color.white);
        frame.add(mealNameTf);

        // Price label
        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(700, 200, 300, 45);
        priceLabel.setForeground(Color.decode("#331402"));
        priceLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(priceLabel);

        // Price text field
        RoundedTextfield priceTf = new RoundedTextfield();
        priceTf.setBounds(700, 240, 300, 45);
        priceTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        priceTf.setBackground(Color.white);
        frame.add(priceTf);

        // Quantity label
        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setBounds(370, 280, 300, 45);
        quantityLabel.setForeground(Color.decode("#331402"));
        quantityLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(quantityLabel);

        // Quantity text field
        RoundedTextfield quantityTf = new RoundedTextfield();
        quantityTf.setBounds(370, 320, 300, 45);
        quantityTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        quantityTf.setBackground(Color.white);
        frame.add(quantityTf);

        // Date label
        JLabel dateLabel = new JLabel("Date");
        dateLabel.setBounds(700, 280, 300, 45);
        dateLabel.setForeground(Color.decode("#331402"));
        dateLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(dateLabel);

        // Date text field
        RoundedTextfield dateTf = new RoundedTextfield();
        dateTf.setBounds(700, 320, 300, 45);
        dateTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        dateTf.setBackground(Color.white);
        frame.add(dateTf);

        // Confirmation label
        JLabel confirmationLabel = new JLabel();
        confirmationLabel.setBounds(850, 460, 300, 30);
        confirmationLabel.setForeground(Color.green);
        frame.add(confirmationLabel);

        // Confirm order button
        JButton confirmOrderButton = new JButton("CONFIRM");
        confirmOrderButton.setBounds(850, 500, 160, 40);
        confirmOrderButton.setBackground(Color.decode("#551F01"));
        confirmOrderButton.setFont(new Font("Arial", Font.PLAIN, 18));
        confirmOrderButton.setForeground(Color.white);
        confirmOrderButton.setFocusable(false);
        confirmOrderButton.setBorder(BorderFactory.createLineBorder(Color.decode("#d87436"), 2));
        confirmOrderButton.addActionListener(e -> {
            String name = mealNameTf.getText();
            String quantity = quantityTf.getText();
            String price = priceTf.getText();
            String date = dateTf.getText();

            // Validate and calculate subtotal price
            try {
                double priceValue = Double.parseDouble(price);
                int quantityValue = Integer.parseInt(quantity);
                double subtotalPrice = priceValue * quantityValue; // Calculate subtotal

                // Call addOrders with the correct parameters
                ordersDatabase.addOrders(name, quantity, String.format("%.2f", subtotalPrice), date);

                // Clear input fields after submission
                mealNameTf.setText("");
                quantityTf.setText("");
                priceTf.setText("");
                dateTf.setText("");

                // Display success message
                confirmationLabel.setText("Order has been added.");
            } catch (NumberFormatException ex) {
                // If there's a NumberFormatException, handle the validation for invalid fields
                if (name.isEmpty() || !isValidPrice(price) || !isValidQuantity(quantity) || date.isEmpty()) {
                    confirmationLabel.setText("Invalid input, please check fields.");
                } else {
                    confirmationLabel.setText("Order has been added.");
                }
            }
        });
        frame.add(confirmOrderButton);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    private static boolean isValidPrice(String price) {
        try {
            Double.parseDouble(price);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidQuantity(String quantity) {
        try {
            Integer.parseInt(quantity);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void editOrdersPage(JFrame frame) {

        new OrderSidePanel(frame);

        JLabel errorMessageLabel = new JLabel();
        errorMessageLabel.setText("Order ID not found!");
        errorMessageLabel.setForeground(Color.red);
        errorMessageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        errorMessageLabel.setBounds(585, 315, 500, 50);
        errorMessageLabel.setVisible(false);  //initially hidden

        JLabel confirmationLabel = new JLabel();
        confirmationLabel.setBounds(585, 370, 500, 50);
        confirmationLabel.setForeground(Color.green);
        confirmationLabel.setFont(new Font("Arial", Font.BOLD, 20));
        confirmationLabel.setVisible(false);  //initially hidden
        frame.add(confirmationLabel);

        RoundedButton inventoryLabel = new RoundedButton("EDIT ORDER");
        inventoryLabel.setBounds(550, 25, 300, 70);
        inventoryLabel.setBackground(Color.decode("#752A00"));
        inventoryLabel.setFont(new Font("Arial", Font.BOLD, 30));
        inventoryLabel.setForeground(Color.decode("#FACD97"));
        inventoryLabel.setFocusable(false);
        frame.add(inventoryLabel);

        JLabel inventoryIdlabel = new JLabel();
        inventoryIdlabel.setText("Enter the order ID of the inventory item you would like to edit:  ");
        inventoryIdlabel.setBounds(390, 190, 800, 45);
        inventoryIdlabel.setForeground(Color.decode("#331402"));
        inventoryIdlabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(inventoryIdlabel);

        RoundedTextfield textField = new RoundedTextfield();
        textField.setBounds(450, 250, 500, 70);
        textField.setBorderColor(Color.decode("#331402"));
        textField.setBorderThickness(4);
        textField.setBackground(Color.WHITE);
        frame.add(textField);

        RoundedButton button = new RoundedButton("CONFIRM");
        button.setBounds(600, 370, 200, 50);
        button.setForeground(Color.white);
        button.setBackground(Color.decode("#551F01"));
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setFocusable(false);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                button.setBackground(Color.decode("#A8775C"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                button.setBackground(Color.decode("#551F01"));
            }
        });
        button.addActionListener(e -> {
            int orderId = Integer.parseInt(textField.getText().trim());

            // Check if the order exists
            if (!ordersDatabase.authenticateOrderId(orderId)) {
                errorMessageLabel.setText("Order ID does not exist!");
                errorMessageLabel.setVisible(true);
                confirmationLabel.setText("");
            } else {
                frame.getContentPane().removeAll();
                frame.repaint();
                frame.revalidate();

                new OrderSidePanel(frame);

                RoundedButton inventoryLabel1 = new RoundedButton("EDIT ORDER");
                inventoryLabel1.setBounds(550, 25, 300, 70);
                inventoryLabel1.setBackground(Color.decode("#752A00"));
                inventoryLabel1.setFont(new Font("Arial", Font.BOLD, 25));
                inventoryLabel1.setForeground(Color.decode("#FACD97"));
                inventoryLabel1.setFocusable(false);
                frame.add(inventoryLabel1);

                // meal name label
                JLabel mealNameLabel = new JLabel();
                mealNameLabel.setText("Meal Name");
                mealNameLabel.setBounds(370, 200, 300, 45);
                mealNameLabel.setForeground(Color.decode("#331402"));
                mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
                frame.add(mealNameLabel);

                // meal name text field
                RoundedTextfield mealNameTf = new RoundedTextfield();
                mealNameTf.setBounds(370, 240, 300, 45);
                mealNameTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                mealNameTf.setBackground(Color.white);
                frame.add(mealNameTf);

                // price label
                JLabel priceLabel = new JLabel();
                priceLabel.setText("Subtotal Price");
                priceLabel.setBounds(700, 200, 300, 45);
                priceLabel.setForeground(Color.decode("#331402"));
                priceLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
                frame.add(priceLabel);

                // price text field
                RoundedTextfield priceTf = new RoundedTextfield();
                priceTf.setBounds(700, 240, 300, 45);
                priceTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                priceTf.setBackground(Color.white);
                frame.add(priceTf);

                // quantity label
                JLabel quantityLabel = new JLabel();
                quantityLabel.setText("Quantity");
                quantityLabel.setBounds(370, 280, 300, 45);
                quantityLabel.setForeground(Color.decode("#331402"));
                quantityLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
                frame.add(quantityLabel);

                // quantity text field
                RoundedTextfield quantityTf = new RoundedTextfield();
                quantityTf.setBounds(370, 320, 300, 45);
                quantityTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                quantityTf.setBackground(Color.white);
                frame.add(quantityTf);

                // date label
                JLabel dateLabel = new JLabel();
                dateLabel.setText("Date");
                dateLabel.setBounds(700, 280, 300, 45);
                dateLabel.setForeground(Color.decode("#331402"));
                dateLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
                frame.add(dateLabel);

                // date text field
                RoundedTextfield dateTf = new RoundedTextfield();
                dateTf.setBounds(700, 320, 300, 45);
                dateTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
                dateTf.setBackground(Color.white);
                frame.add(dateTf);

                JButton editOrderButton = new JButton();
                editOrderButton.setText("CONFIRM");
                editOrderButton.setBounds(850, 500, 160, 40);
                editOrderButton.setBackground(Color.decode("#551F01"));
                editOrderButton.setFont(new Font("Arial", Font.BOLD, 18));
                editOrderButton.setForeground(Color.white);
                editOrderButton.setFocusable(false);

                editOrderButton.addActionListener(e2 -> {
                    String date = dateTf.getText().trim();
                    String mealName = mealNameTf.getText().trim();
                    String quantity = quantityTf.getText().trim();
                    String price = priceTf.getText().trim();
                    String orderId1 = textField.getText().trim();

                    Integer mealId = ordersDatabase.getMealIdByName(mealName);
                    if (mealId == null) {
                        // show error message if meal name is not found
                        errorMessageLabel.setVisible(true);
                        frame.add(errorMessageLabel);
                    } else {
                        // update order
                        ordersDatabase.updateOrder(date, mealName, quantity, price, orderId1);
                        confirmationLabel.setText("Order ID " + orderId1 + " has been edited.");
                        confirmationLabel.setVisible(true);
                        errorMessageLabel.setVisible(false);
                    }
                });
                frame.add(editOrderButton);
            }
        });
        frame.add(errorMessageLabel);
        frame.add(button);
        frame.setVisible(true);
    }


    //delete orders page
    public static void deleteOrdersPage(JFrame frame) {

        new OrderSidePanel(frame);

        // delete order button
        JLabel deleteOrderLabel = new JLabel("DELETE ORDER");
        deleteOrderLabel.setBounds(500, 50, 430, 80);
        deleteOrderLabel.setOpaque(true);
        deleteOrderLabel.setBackground(Color.decode("#752A00"));
        deleteOrderLabel.setForeground(Color.decode("#FACD97"));
        deleteOrderLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 40));
        deleteOrderLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(6, 10, 6, 10)
        ));

        //add this if naa nay image
//        ImageIcon icon = new ImageIcon("path/to/your/image.png"); // Replace with the path to your image
//        addOrderLabel.setIcon(icon);
//        addOrderLabel.setHorizontalTextPosition(SwingConstants.RIGHT); // Text on the right, image on the left

        deleteOrderLabel.setHorizontalAlignment(SwingConstants.RIGHT); //align text to the right
        frame.add(deleteOrderLabel);

        // order ID label
        JLabel orderIdLabel = new JLabel();
        orderIdLabel.setText("Enter the ID of the order you would like to delete: ");
        orderIdLabel.setBounds(480, 190, 600, 45);
        orderIdLabel.setForeground(Color.decode("#331402"));
        orderIdLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 20));
        frame.add(orderIdLabel);

        // order ID text field
        RoundedTextfield orderIdTf = new RoundedTextfield();
        orderIdTf.setBounds(460, 230, 500, 45);
        orderIdTf.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
        orderIdTf.setBackground(Color.white);
        frame.add(orderIdTf);

        // delete order button
        JButton deleteOrderButton = new JButton();
        deleteOrderButton.setText("CONFIRM");
        deleteOrderButton.setBounds(580, 370, 250, 40);
        deleteOrderButton.setBackground(Color.decode("#551F01"));
        deleteOrderButton.setFont(new Font("Arial", Font.BOLD, 18));
        deleteOrderButton.setForeground(Color.white);
        deleteOrderButton.setFocusable(false);
        deleteOrderButton.addActionListener(e -> {
            String orderId = orderIdTf.getText();

            if (ordersDatabase.deleteOrder(Integer.parseInt(orderId))) {
                JOptionPane.showMessageDialog(frame, "Order deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(frame, "Order ID not found.");
            }

            orderIdTf.setText("");
        });
        frame.add(deleteOrderButton);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}