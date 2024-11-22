package org.example;

import org.example.Databases.ordersDatabase;
import org.example.Extensions.SearchBar;
import org.example.SidePanels.OrderSidePanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class OrdersPage {

    public OrdersPage(JFrame frame) {
        frame.setTitle("Orders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().removeAll();
        frame.setLayout(null);

        new OrderSidePanel(frame);
        new SearchBar(frame);

        frame.revalidate();
        frame.repaint();

        // Header labels
        String[] headers = {"Order ID", "Date", "Meal", "Quantity", "Total Price", "Status"};
        int[] columnWidths = {90, 140, 160, 90, 110, 110};
        int xOffset = 330;

        for (int i = 0; i < headers.length; i++) {
            JLabel headerLabel = createHeaderLabel(headers[i]);
            headerLabel.setBounds(xOffset, 80, columnWidths[i], 40);
            frame.add(headerLabel);
            xOffset += columnWidths[i] + 10;
        }

        // Container panel for all rows
        JPanel ordersPanel = new JPanel();
        ordersPanel.setLayout(null); // Absolute layout for precise positioning
        ordersPanel.setBackground(Color.decode("#EF9B39"));

        List<String[]> orders = ordersDatabase.listOrders();
        int rowHeight = 50;
        int yPosition = 0;

        for (String[] order : orders) {
            int xPosition = 0;

            // Create and add cells for each column
            for (int i = 0; i < headers.length; i++) {
                JPanel cellPanel = createCellPanel(i == 5 ? null : order[i]);
                if (i == 5) { // Add status dropdown
                    cellPanel.add(createStatusDropdown(order), BorderLayout.CENTER);
                }
                cellPanel.setBounds(xPosition, yPosition, columnWidths[i], rowHeight);
                ordersPanel.add(cellPanel);
                xPosition += columnWidths[i] + 10;
            }
            yPosition += rowHeight;
        }

        ordersPanel.setPreferredSize(new Dimension(xOffset, yPosition));

        // Add scroll pane
        JScrollPane scrollPane = new JScrollPane(ordersPanel);
        scrollPane.setBounds(330, 140, 800, 400);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        frame.add(scrollPane);
    }

    private JLabel createHeaderLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.decode("#752A00"));
        label.setForeground(Color.decode("#EF9B39"));
        label.setFont(new Font("Milonga", Font.BOLD, 14));
        label.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        return label;
    }

    private JPanel createCellPanel(String text) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
        panel.setBackground(Color.decode("#752A00"));

        if (text != null) {
            JLabel label = new JLabel(text, SwingConstants.CENTER);
            label.setFont(new Font("Milonga", Font.PLAIN, 14));
            label.setForeground(Color.decode("#EF9B39"));
            panel.add(label, BorderLayout.CENTER);
        }
        return panel;
    }

    private JComboBox<String> createStatusDropdown(String[] order) {
        String[] statuses = {"Pending", "Completed"};
        JComboBox<String> comboBox = new JComboBox<>(statuses);
        comboBox.setBackground(Color.decode("#752A00"));
        comboBox.setFocusable(false);
        comboBox.setBorder(BorderFactory.createEmptyBorder());
        comboBox.setSelectedItem(order[5]);

        // Set initial text color
        comboBox.setForeground(order[5].equals("Pending") ? Color.RED : Color.GREEN);

        comboBox.addActionListener(e -> {
            String selectedStatus = (String) comboBox.getSelectedItem();
            int orderId = Integer.parseInt(order[0]);

            // Update text color based on the selected status
            if ("Pending".equals(selectedStatus)) {
                comboBox.setForeground(Color.RED);
            } else if ("Completed".equals(selectedStatus)) {
                comboBox.setForeground(Color.GREEN);
            }

            // Update the database
            ordersDatabase.updateOrderStatus(orderId, selectedStatus);
        });

        return comboBox;
    }
}
