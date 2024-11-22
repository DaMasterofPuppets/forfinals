package org.example;

import org.example.Databases.inventoryDatabase;
import org.example.Databases.mealsDatabase;
import org.example.Extensions.RoundedButton;
import org.example.Extensions.SearchBar;
import org.example.SidePanels.InventorySidePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Inventory {

    private void styleLabel(JLabel label) {
        label.setOpaque(true);
        label.setBackground(Color.decode("#752A00"));
        label.setForeground(Color.decode("#EF9B39"));
        label.setFont(new Font("Milonga", Font.BOLD, 18));
        label.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#551F01"), 3),
                BorderFactory.createEmptyBorder(3, 10, 3, 10)
        ));
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void GUI (JFrame frame) {
        new InventorySidePanel(frame);
        new SearchBar(frame);

        // Column labels
        JLabel inventoryIdLabel = new JLabel("Inventory ID");
        inventoryIdLabel.setBounds(350, 80, 150, 45);
        styleLabel(inventoryIdLabel);
        frame.add(inventoryIdLabel);

        JLabel mealIdLabel = new JLabel("Meal ID");
        mealIdLabel.setBounds(510, 80, 130, 45);
        styleLabel(mealIdLabel);
        frame.add(mealIdLabel);

        JLabel mealNameLabel = new JLabel("Meal Name");
        mealNameLabel.setBounds(650, 80, 140, 45);
        styleLabel(mealNameLabel);
        frame.add(mealNameLabel);

        JLabel quantityLabel = new JLabel("Stock");
        quantityLabel.setBounds(800, 80, 130, 45);
        styleLabel(quantityLabel);
        frame.add(quantityLabel);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(940, 80, 130, 45);
        styleLabel(priceLabel);
        frame.add(priceLabel);

        RoundedButton allMealsButton = new RoundedButton("All");
        allMealsButton.setBounds(350, 550, 60, 30);
        allMealsButton.setBackground(Color.decode("#331402"));
        allMealsButton.setForeground(Color.decode("#FACD97"));
        allMealsButton.setFocusable(false);
        allMealsButton.setRound(10);
        allMealsButton.setBorderThickness(0);
        frame.add(allMealsButton);

        RoundedButton allVegMealsButton = new RoundedButton("Vegetarian");
        allVegMealsButton.setBounds(420, 550, 140, 30);
        allVegMealsButton.setBackground(Color.decode("#331402"));
        allVegMealsButton.setForeground(Color.decode("#FACD97"));
        allVegMealsButton.setFocusable(false);
        allVegMealsButton.setRound(10);
        allVegMealsButton.setBorderThickness(0);
        frame.add(allVegMealsButton);

        RoundedButton allNonVegMealsButton = new RoundedButton("Non-Vegetarian");
        allNonVegMealsButton.setBounds(570, 550, 160, 30);
        allNonVegMealsButton.setBackground(Color.decode("#331402"));
        allNonVegMealsButton.setForeground(Color.decode("#FACD97"));
        allNonVegMealsButton.setFocusable(false);
        allNonVegMealsButton.setRound(10);
        allNonVegMealsButton.setBorderThickness(0);
        frame.add(allNonVegMealsButton);
    }

    public void dataPanel (List<String[]> inventoryIds) {
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(null); // Use null layout for precise positioning
        dataPanel.setBackground(Color.decode("#EF9B39"));
        dataPanel.setPreferredSize(new Dimension(750, inventoryIds.size() * 55)); // Adjust height based on number of rows

        //Create panel to hold inventory id panels
        JPanel inventoryIdPanelContainer = new JPanel();
        inventoryIdPanelContainer.setLayout(new BoxLayout(inventoryIdPanelContainer, BoxLayout.Y_AXIS));

        JPanel mealIdPanelContainer = new JPanel();
        mealIdPanelContainer.setLayout(new BoxLayout(mealIdPanelContainer, BoxLayout.Y_AXIS));

        JPanel mealNamePanelContainer = new JPanel();
        mealNamePanelContainer.setLayout(new BoxLayout(mealNamePanelContainer, BoxLayout.Y_AXIS));

        JPanel quantityPanelContainer = new JPanel();
        quantityPanelContainer.setLayout(new BoxLayout(quantityPanelContainer, BoxLayout.Y_AXIS));

        JPanel pricePanelContainer = new JPanel();
        pricePanelContainer.setLayout(new BoxLayout(pricePanelContainer, BoxLayout.Y_AXIS));

        for (String[] inventoryId : inventoryIds) {
            // Create inventoryId panel
            JPanel inventoryIdPanel = new JPanel();
            inventoryIdPanel.setLayout(new BorderLayout());
            inventoryIdPanel.setPreferredSize(new Dimension(200, 50));
            inventoryIdPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
            inventoryIdPanel.setBackground(Color.decode("#752A00"));

            JLabel idLabel = new JLabel(inventoryId[0], SwingConstants.CENTER);
            idLabel.setFont(new Font("Milonga", Font.BOLD, 14));
            idLabel.setForeground(Color.decode("#EF9B39"));
            inventoryIdPanel.add(idLabel, BorderLayout.CENTER);

            // Add inventoryIdPanel to container
            inventoryIdPanelContainer.add(inventoryIdPanel);

            // Create mealId panel
            JPanel mealIdPanel = new JPanel();
            mealIdPanel.setLayout(new BorderLayout());
            mealIdPanel.setPreferredSize(new Dimension(200, 50));
            mealIdPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
            mealIdPanel.setBackground(Color.decode("#752A00"));

            JLabel mealIdLabel2 = new JLabel(inventoryId[1], SwingConstants.CENTER);
            mealIdLabel2.setFont(new Font("Milonga", Font.BOLD, 14));
            mealIdLabel2.setForeground(Color.decode("#EF9B39"));
            mealIdPanel.add(mealIdLabel2, BorderLayout.CENTER);

            // Add mealIdPanel to container
            mealIdPanelContainer.add(mealIdPanel);

            // Create mealName panel
            JPanel mealNamePanel = new JPanel();
            mealNamePanel.setLayout(new BorderLayout());
            mealNamePanel.setPreferredSize(new Dimension(200, 50));
            mealNamePanel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
            mealNamePanel.setBackground(Color.decode("#752A00"));

            JLabel mealNameLabel2 = new JLabel(inventoryId[2], SwingConstants.CENTER);
            mealNameLabel2.setFont(new Font("Milonga", Font.BOLD, 14));
            mealNameLabel2.setForeground(Color.decode("#EF9B39"));
            mealNamePanel.add(mealNameLabel2, BorderLayout.CENTER);
            mealNamePanelContainer.add(mealNamePanel);

            // Create quantity panel
            JPanel quantityPanel = new JPanel();
            quantityPanel.setLayout(new BorderLayout());
            quantityPanel.setPreferredSize(new Dimension(200, 50));
            quantityPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
            quantityPanel.setBackground(Color.decode("#752A00"));

            int quantity = Integer.parseInt(inventoryId[3]);  // Assuming quantity is at index 3
            JLabel quantityLabel2 = new JLabel(String.valueOf(quantity), SwingConstants.CENTER);
            quantityLabel2.setFont(new Font("Milonga", Font.BOLD, 14));
            quantityLabel2.setForeground(Color.decode("#EF9B39"));

            if (quantity < 5) {
                quantityLabel2.setForeground(Color.RED);
            }

            quantityPanel.add(quantityLabel2, BorderLayout.CENTER);

            // Add quantityPanel to container
            quantityPanelContainer.add(quantityPanel);

            // Create price panel
            JPanel pricePanel = new JPanel();
            pricePanel.setLayout(new BorderLayout());
            pricePanel.setPreferredSize(new Dimension(200, 50));
            pricePanel.setBorder(BorderFactory.createLineBorder(Color.decode("#551F01"), 3));
            pricePanel.setBackground(Color.decode("#752A00"));

            JLabel priceLabel2 = new JLabel(inventoryId[4], SwingConstants.CENTER);
            priceLabel2.setFont(new Font("Milonga", Font.BOLD, 14));
            priceLabel2.setForeground(Color.decode("#EF9B39"));
            pricePanel.add(priceLabel2, BorderLayout.CENTER);

            // Add pricePanel to container
            pricePanelContainer.add(pricePanel);
        }

        // Add individual column containers to dataPanel
        inventoryIdPanelContainer.setBounds(0, 0, 150, inventoryIds.size() * 55);
        mealIdPanelContainer.setBounds(160, 0, 130, inventoryIds.size() * 55);
        mealNamePanelContainer.setBounds(300, 0, 140, inventoryIds.size() * 55);
        quantityPanelContainer.setBounds(450, 0, 130, inventoryIds.size() * 55);
        pricePanelContainer.setBounds(590, 0, 130, inventoryIds.size() * 55);

        dataPanel.add(inventoryIdPanelContainer);
        dataPanel.add(mealIdPanelContainer);
        dataPanel.add(mealNamePanelContainer);
        dataPanel.add(quantityPanelContainer);
        dataPanel.add(pricePanelContainer);
    }

    public Inventory(JFrame frame) {
        frame.setTitle("Inventory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().removeAll();
        frame.setLayout(null);

        GUI(frame);

        List<String[]> inventoryIds = inventoryDatabase.listInventory();
        dataPanel(inventoryIds);
    }

    public void vegetarianMeals (JFrame frame) {

        GUI(frame);

        List<String[]> inventoryIds = inventoryDatabase.getVegetarianMeals();

        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(null);
        dataPanel.setBackground(Color.decode("#EF9B39"));
        dataPanel.setPreferredSize(new Dimension(750, inventoryIds.size() * 55));

        dataPanel(inventoryIds);

        // Create a scrollable area for inventory data
        JScrollPane scrollPane = new JScrollPane(dataPanel);
        scrollPane.setBounds(350, 140, 735, 400); // Position and size of the scrolling area
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.setBackground(Color.decode("#EF9B39"));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollPane);


    }

    public void nonVegetarianMeals (JFrame frame) {

    }
}
