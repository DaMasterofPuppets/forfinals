package org.example;

import org.example.Databases.inventoryDatabase;
import org.example.Extensions.SearchBar;
import org.example.SidePanels.InventorySidePanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InventoryPage {

    public InventoryPage(JFrame frame) {
        frame.setTitle("Inventory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().removeAll();
        frame.setLayout(null);

        new InventorySidePanel(frame);
        new SearchBar(frame);

        frame.revalidate();
        frame.repaint();

        // Header labels
        String[] headers = {"Inventory ID", "Meal ID", "Meal Name", "Stock", "Price"};
        int[] columnWidths = {150, 130, 140, 130, 130};
        int xOffset = 350;

        for (int i = 0; i < headers.length; i++) {
            JLabel headerLabel = createHeaderLabel(headers[i]);
            headerLabel.setBounds(xOffset, 80, columnWidths[i], 40);
            frame.add(headerLabel);
            xOffset += columnWidths[i] + 10;
        }

        // Container panel for all rows
        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setLayout(null); // Absolute layout for precise positioning
        inventoryPanel.setBackground(Color.decode("#EF9B39"));

        List<String[]> inventory = inventoryDatabase.listInventory();
        int rowHeight = 50;
        int yPosition = 0;

        for (String[] entry : inventory) {
            int xPosition = 0;

            // Create and add cells for each column
            for (int i = 0; i < headers.length; i++) {
                JPanel cellPanel = createCellPanel(entry[i]);
                if (i == 3) { // Special formatting for stock (index 3)
                    int quantity = Integer.parseInt(entry[i]);
                    JLabel quantityLabel = (JLabel) cellPanel.getComponent(0);
                    if (quantity < 5) {
                        quantityLabel.setFont(new Font("Milonga", Font.BOLD, 14));
                        quantityLabel.setForeground(Color.RED);
                    }
                }
                cellPanel.setBounds(xPosition, yPosition, columnWidths[i], rowHeight);
                inventoryPanel.add(cellPanel);
                xPosition += columnWidths[i] + 10;
            }
            yPosition += rowHeight;
        }

        inventoryPanel.setPreferredSize(new Dimension(xOffset, yPosition));

        // Add scroll pane
        JScrollPane scrollPane = new JScrollPane(inventoryPanel);
        scrollPane.setBounds(350, 140, 800, 400);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        frame.add(scrollPane);

        // "All Meals" button
        JButton allMealsButton = createRoundedButton("All", 350, 60);
        allMealsButton.addActionListener(e -> refreshInventoryData(inventoryPanel, inventoryDatabase.listInventory(), columnWidths, rowHeight));
        frame.add(allMealsButton);

        // "All Meals" button
        JButton vegMealsButton = createRoundedButton("Vegetarian", 420, 140);
        vegMealsButton.addActionListener(e -> refreshInventoryData(inventoryPanel, inventoryDatabase.getVegetarianMeals(), columnWidths, rowHeight));
        frame.add(vegMealsButton);

        // "All Meals" button
        JButton nonVegMealsButton = createRoundedButton("Non-Vegetarian", 570, 160);
        nonVegMealsButton.addActionListener(e -> refreshInventoryData(inventoryPanel, inventoryDatabase.getNonVegetarianMeals(), columnWidths, rowHeight));
        frame.add(nonVegMealsButton);
    }

    private JLabel createHeaderLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.decode("#752A00"));
        label.setForeground(Color.decode("#EF9B39"));
        label.setFont(new Font("Milonga", Font.BOLD, 18));
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

    private JButton createRoundedButton(String text, int x, int width) {
        JButton button = new JButton(text);
        button.setBounds(x, 550, width, 30);
        button.setBackground(Color.decode("#331402"));
        button.setForeground(Color.decode("#FACD97"));
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setFont(new Font("Milonga", Font.BOLD, 12));
        return button;
    }

    private void refreshInventoryData(JPanel inventoryPanel, List<String[]> inventory, int[] columnWidths, int rowHeight) {
        inventoryPanel.removeAll();
        int yPosition = 0;

        for (String[] entry : inventory) {
            int xPosition = 0;

            for (int i = 0; i < entry.length; i++) {
                JPanel cellPanel = createCellPanel(entry[i]);
                if (i == 3) { // Special formatting for stock
                    int quantity = Integer.parseInt(entry[i]);
                    JLabel quantityLabel = (JLabel) cellPanel.getComponent(0);
                    if (quantity < 5) {
                        quantityLabel.setForeground(Color.RED);
                    }
                }
                cellPanel.setBounds(xPosition, yPosition, columnWidths[i], rowHeight);
                inventoryPanel.add(cellPanel);
                xPosition += columnWidths[i] + 10;
            }
            yPosition += rowHeight;
        }

        inventoryPanel.setPreferredSize(new Dimension(inventoryPanel.getWidth(), yPosition));
        inventoryPanel.revalidate();
        inventoryPanel.repaint();
    }
}
