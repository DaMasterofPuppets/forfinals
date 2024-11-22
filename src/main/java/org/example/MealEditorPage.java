package org.example;

import org.example.Databases.mealsDatabase;
import org.example.Extensions.RoundedBorder;
import org.example.Extensions.RoundedButton;
import org.example.Extensions.RoundedTextfield;
import org.example.SidePanels.MealSidePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MealEditorPage {

    JLabel mealNameLabel = new JLabel();
    RoundedTextfield mealNameTf = new RoundedTextfield();
    RoundedButton breakfastButton = new RoundedButton("breakfast");
    RoundedButton lunchButton = new RoundedButton("lunch");
    RoundedButton dinnerButton = new RoundedButton("dinner");
    RoundedButton vegButton = new RoundedButton("vegetarian");
    RoundedButton nonvegButton = new RoundedButton("non-vegetarian");
    RoundedButton spicyButton = new RoundedButton("spicy");
    RoundedButton nonspicyButton = new RoundedButton("not-spicy");
    RoundedButton gramsButton = new RoundedButton("g");
    RoundedButton ozButton = new RoundedButton("mL");
    RoundedButton addButton = new RoundedButton("Add");
    RoundedButton addMeal = new RoundedButton("ADD MEAL");
    RoundedButton editMeal = new RoundedButton("EDIT MEAL");
    RoundedButton removeMeal = new RoundedButton("REMOVE MEAL");
    JLabel error = new JLabel("Meal not found");
    String category = "breakfast";
    String dietType = "non-vegetarian";
    String spiceType = "not-spicy";
    String unit = "g";

    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public MealEditorPage(JFrame frame) {

        frame.setTitle("Meal Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //close the application when the window is closed

        frame.getContentPane().setBackground(Color.decode("#EF9B39"));
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

        //side panel
        new MealSidePanel(frame);

        ImageIcon img = new ImageIcon("src/main/java/org/example/img/meal editor.png");
        JLabel imageLabel = new JLabel(img);
        imageLabel.setBounds(235, 50, 500, 500);
        frame.add(imageLabel);

        RoundedButton mealEditor = new RoundedButton("MEAL EDITOR");
        mealEditor.setBounds(650, 50, 365, 90);
        mealEditor.setBackground(Color.decode("#752A00"));
        mealEditor.setFont(new Font("Arial", Font.BOLD, 45));
        mealEditor.setForeground(Color.decode("#EF9B39"));
        frame.add(mealEditor);

        JLabel label = new JLabel("Hello! What would you like to do?");
        label.setBounds(650, 150, 1000, 100);
        label.setForeground(Color.decode("#752A00"));
        label.setFont(new Font("Arial", Font.PLAIN, 26));
        frame.add(label);


        addMeal.setBounds(650, 250, 365, 85);
        addMeal.setBackground(Color.white);
        addMeal.setFont(new Font ("Arial", Font.BOLD, 32));
        addMeal.setBorderThickness(2);
        addMeal.setBorderColor(Color.decode("#331402"));
        addMeal.setForeground(Color.decode("#551F01"));
        addMeal.setFocusable(false);
        addMeal.addActionListener(e -> {
            frame.getContentPane().removeAll();
            addMeal(frame);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(addMeal);

        editMeal.setBounds(650, 350, 365, 85);
        editMeal.setBackground(Color.white);
        editMeal.setFont(new Font ("Arial", Font.BOLD, 32));
        editMeal.setBorderThickness(2);
        editMeal.setForeground(Color.decode("#551F01"));
        editMeal.setFocusable(false);
        editMeal.addActionListener(e -> {
            frame.getContentPane().removeAll();
            editMeal(frame);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(editMeal);

        removeMeal.setBounds(650, 450, 365, 85);
        removeMeal.setBackground(Color.white);
        removeMeal.setFont(new Font ("Arial", Font.BOLD, 32));
        removeMeal.setBorderThickness(2);
        removeMeal.setBorderColor(Color.decode("#331402"));
        removeMeal.setForeground(Color.decode("#551F01"));
        removeMeal.setFocusable(false);
        removeMeal.addActionListener(e -> {
            frame.getContentPane().removeAll();
            deleteMeal(frame);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(removeMeal);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void addMeal(JFrame frame) {


        new MealSidePanel(frame);

        //Add Meal
        RoundedButton mealLabel = new RoundedButton("ADD MEAL");
        mealLabel.setBounds(550, 25, 300, 70);
        mealLabel.setBackground(Color.decode("#752A00"));
        mealLabel.setFont(new Font("Arial", Font.BOLD, 35));
        mealLabel.setForeground(Color.decode("#FACD97"));
        mealLabel.setFocusable(false);
        frame.add(mealLabel);

        //Add Meal Name Label
        mealNameLabel.setText("Meal Name");
        mealNameLabel.setBounds(350, 130, 250, 30);
        mealNameLabel.setForeground(Color.decode("#331402"));
        mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.PLAIN, 20));
        frame.add(mealNameLabel);

        //Add Meal Name TextField
        mealNameTf.setBounds(350, 160, 300, 50);
        mealNameTf.setBackground(Color.white);
        frame.add(mealNameTf);

        //Add Description Label
        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setBounds(350, 230, 250, 30);
        descriptionLabel.setForeground(Color.decode("#331402"));
        descriptionLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.PLAIN, 20));
        frame.add(descriptionLabel);

        //Add Description TextField
        RoundedTextfield descriptionTf = new RoundedTextfield ();
        descriptionTf.setBounds(350, 260, 300, 50);
        descriptionTf.setBackground(Color.white);
        frame.add(descriptionTf);

        //Add Category Label
        JLabel categoryLabel = new JLabel("Category");
        categoryLabel.setBounds(350, 330, 250, 30);
        categoryLabel.setForeground(Color.decode("#331402"));
        categoryLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.PLAIN, 20));
        frame.add(categoryLabel);

        //Add Category Button
        breakfastButton.setBounds(350, 360, 90, 50);
        breakfastButton.setBackground(Color.white);
        breakfastButton.setForeground(Color.black);
        breakfastButton.setFocusable(false);
        breakfastButton.addActionListener(e -> {
            breakfastButton.setBackground(Color.decode("#551F01"));
            dinnerButton.setBackground(Color.white);
            lunchButton.setBackground(Color.white);
            breakfastButton.setForeground(Color.white);
            lunchButton.setForeground(Color.black);
            dinnerButton.setForeground(Color.black);
            category = "breakfast";
        });
        frame.add(breakfastButton);
        lunchButton.setBounds(450, 360, 90, 50);
        lunchButton.setBackground(Color.white);
        lunchButton.setForeground(Color.black);
        lunchButton.setFocusable(false);
        lunchButton.addActionListener(e -> {
            lunchButton.setBackground(Color.decode("#551F01"));
            breakfastButton.setBackground(Color.white);
            dinnerButton.setBackground(Color.white);
            lunchButton.setForeground(Color.white);
            breakfastButton.setForeground(Color.black);
            dinnerButton.setForeground(Color.black);
            category = "lunch";
        });
        frame.add(lunchButton);
        dinnerButton.setBounds(550, 360, 90, 50);
        dinnerButton.setBackground(Color.white);
        dinnerButton.setForeground(Color.black);
        dinnerButton.setFocusable(false);
        dinnerButton.addActionListener(e -> {
            dinnerButton.setBackground(Color.decode("#551F01"));
            breakfastButton.setBackground(Color.white);
            lunchButton.setBackground(Color.white);
            dinnerButton.setForeground(Color.white);
            lunchButton.setForeground(Color.black);
            breakfastButton.setForeground(Color.black);
            category = "dinner";
        });
        frame.add(dinnerButton);

        //Add Ingredients Label
        JLabel ingredientsLabel = new JLabel("Ingredients");
        ingredientsLabel.setBounds(350, 430, 250, 30);
        ingredientsLabel.setForeground(Color.decode("#331402"));
        ingredientsLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.PLAIN, 20));
        frame.add(ingredientsLabel);

        //Add Ingredients TextField
        RoundedTextfield ingredientsTf = new RoundedTextfield();
        ingredientsTf.setBounds(350, 460, 300, 50);
        ingredientsTf.setBackground(Color.white);
        frame.add(ingredientsTf);

        //Add Diet Type Label
        JLabel dietTypeLabel = new JLabel("Diet Type");
        dietTypeLabel.setBounds(700, 130, 250, 30);
        dietTypeLabel.setForeground(Color.decode("#331402"));
        dietTypeLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.PLAIN, 20));
        frame.add(dietTypeLabel);

        //Add Diet Type buttons
        vegButton.setBounds(700, 160, 145, 50);
        vegButton.setBackground(Color.white);
        vegButton.setForeground(Color.black);
        vegButton.setFocusable(false);
        vegButton.addActionListener(e -> {
            vegButton.setBackground(Color.decode("#551F01"));
            nonvegButton.setBackground(Color.white);
            vegButton.setForeground(Color.white);
            nonvegButton.setForeground(Color.black);
            dietType = "vegetarian";
        });
        frame.add(vegButton);
        nonvegButton.setBounds(860, 160, 145, 50);
        nonvegButton.setBackground(Color.white);
        nonvegButton.setForeground(Color.black);
        nonvegButton.setFocusable(false);
        nonvegButton.addActionListener(e -> {
            nonvegButton.setBackground(Color.decode("#551F01"));
            vegButton.setBackground(Color.white);
            nonvegButton.setForeground(Color.white);
            vegButton.setForeground(Color.black);
            dietType = "non-vegetarian";
        });
        frame.add(nonvegButton);

        //Add Spice Type Label
        JLabel spiceTypeLabel = new JLabel("Spice Type");
        spiceTypeLabel.setBounds(700, 230, 250, 30);
        spiceTypeLabel.setForeground(Color.decode("#331402"));
        spiceTypeLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.PLAIN, 20));
        frame.add(spiceTypeLabel);

        //Add Spic Type Buttons
        spicyButton.setBounds(700, 260, 145, 50);
        spicyButton.setBackground(Color.white);
        spicyButton.setForeground(Color.black);
        spicyButton.setFocusable(false);
        spicyButton.addActionListener(e -> {
            spicyButton.setBackground(Color.decode("#551F01"));
            nonspicyButton.setBackground(Color.white);
            spicyButton.setForeground(Color.white);
            nonspicyButton.setForeground(Color.black);
            spiceType = "spicy";
        });
        frame.add(spicyButton);
        nonspicyButton.setBounds(860, 260, 145,50);
        nonspicyButton.setBackground(Color.white);
        nonspicyButton.setForeground(Color.black);
        nonspicyButton.setFocusable(false);
        nonspicyButton.addActionListener(e -> {
            nonspicyButton.setBackground(Color.decode("#551F01"));
            spicyButton.setBackground(Color.white);
            nonspicyButton.setForeground(Color.white);
            spicyButton.setForeground(Color.black);
            spiceType = "not-spicy";
        });
        frame.add(nonspicyButton);

        //Add Serving Size Label
        JLabel servingSizeLabel = new JLabel("Serving Size");
        servingSizeLabel.setBounds(700, 330, 250, 30);
        servingSizeLabel.setForeground(Color.decode("#331402"));
        servingSizeLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.PLAIN, 20));
        frame.add(servingSizeLabel);

        //Add Serving Size TextField
        RoundedTextfield servingSizeTf = new RoundedTextfield();
        servingSizeTf.setBounds(700, 360, 145, 50);
        servingSizeTf.setBackground(Color.white);
        frame.add(servingSizeTf);

        gramsButton.setBounds(860, 360, 70, 50);
        gramsButton.setBackground(Color.white);
        gramsButton.setForeground(Color.black);
        gramsButton.setFocusable(false);
        gramsButton.addActionListener(e -> {
            gramsButton.setBackground(Color.decode("#551F01"));
            ozButton.setBackground(Color.white);
            gramsButton.setForeground(Color.white);
            ozButton.setForeground(Color.black);
            unit = "g";
        });
        frame.add(gramsButton);
        ozButton.setBounds(935, 360, 70, 50);
        ozButton.setBackground(Color.white);
        ozButton.setForeground(Color.black);
        ozButton.setFocusable(false);
        ozButton.addActionListener(e -> {
            ozButton.setBackground(Color.decode("#551F01"));
            gramsButton.setBackground(Color.white);
            ozButton.setForeground(Color.white);
            gramsButton.setForeground(Color.black);
            unit = "mL";
        });
        frame.add(ozButton);

        //Add Nutritional Value Label
        JLabel nutValueLabel = new JLabel("Nutritional Value (calories)");
        nutValueLabel.setBounds(700, 430, 250, 30);
        nutValueLabel.setForeground(Color.decode("#331402"));
        nutValueLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.PLAIN, 20));
        frame.add(nutValueLabel);

        //Add Nutritional Value TextField
        RoundedTextfield nutValueTf = new RoundedTextfield();
        nutValueTf.setBounds(700, 460, 300, 50);
        nutValueTf.setBackground(Color.white);
        frame.add(nutValueTf);

        //Add Add Meal button
        addButton.setText("CONFIRM");
        addButton.setBounds(820, 530, 180, 45);
        addButton.setBackground(Color.decode("#551F01"));
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setForeground(Color.white);
        addButton.setFocusable(false);
        addButton.setBorder(new RoundedBorder(50, Color.decode("#EF9B39")));
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                addButton.setBackground(Color.decode("#A8775C"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                addButton.setBackground(Color.decode("#551F01"));
            }
        });
        addButton.addActionListener(e -> {
            String name = mealNameTf.getText();
            String description = descriptionTf.getText();
            String categ = category;
            String ingredients = ingredientsTf.getText();
            String diet = dietType;
            String spice = spiceType;
            String servingSize = servingSizeTf.getText();
            String Unit = unit;
            String nutritionalValue = nutValueTf.getText();
            mealsDatabase.addMeals(name, description, categ, ingredients, diet, spice, servingSize, Unit, nutritionalValue);
            mealNameTf.setText("");
            descriptionTf.setText("");
            ingredientsTf.setText("");
            servingSizeTf.setText("");
            nutValueTf.setText("");
            breakfastButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
            breakfastButton.setBackground(Color.white);
            breakfastButton.setForeground(Color.black);
            lunchButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
            lunchButton.setBackground(Color.white);
            lunchButton.setForeground(Color.black);
            dinnerButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
            dinnerButton.setBackground(Color.white);
            dinnerButton.setForeground(Color.black);
            vegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
            vegButton.setBackground(Color.white);
            vegButton.setForeground(Color.black);
            nonvegButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
            nonvegButton.setBackground(Color.white);
            nonvegButton.setForeground(Color.black);
            spicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
            spicyButton.setBackground(Color.white);
            spicyButton.setForeground(Color.black);
            nonspicyButton.setBorder(BorderFactory.createLineBorder(Color.decode("#7c8a92"), 2));
            nonspicyButton.setBackground(Color.white);
            nonspicyButton.setForeground(Color.black);
            gramsButton.setBackground(Color.white);
            gramsButton.setForeground(Color.black);
            ozButton.setBackground(Color.white);
            ozButton.setForeground(Color.black);
            new ConfirmPage(frame);
        });
        frame.add(addButton);
    }

    public void editMeal(JFrame frame) {

        new MealSidePanel(frame);

        //Edit Meal
        RoundedButton mealLabel = new RoundedButton("EDIT MEAL");
        mealLabel.setBounds(550, 25, 300, 70);
        mealLabel.setBackground(Color.decode("#752A00"));
        mealLabel.setFont(new Font("Arial", Font.BOLD, 35));
        mealLabel.setForeground(Color.decode("#FACD97"));
        mealLabel.setFocusable(false);
        frame.add(mealLabel);

        JLabel label = new JLabel("Enter the name of the meal you would like to edit:");
        label.setBounds(430, 200, 1000, 50);
        label.setForeground(Color.decode("#331402"));
        label.setFont(new Font("Arial", Font.PLAIN, 26));
        frame.add(label);

        RoundedTextfield textField = new RoundedTextfield();
        textField.setBounds(450, 250, 500, 70);
        textField.setBorderColor(Color.decode("#331402"));
        textField.setBorderThickness(4);
        textField.setBackground(Color.WHITE);
        frame.add(textField);

        // Button to confirm meal selection
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

            String mealName = textField.getText().trim();

            if(mealsDatabase.authenticateMealName(mealName)) {
                frame.getContentPane().removeAll();
                frame.repaint();
                frame.revalidate();

                new MealSidePanel(frame);

                //Add Meal
                RoundedButton mealLabel1 = new RoundedButton("EDIT MEAL");
                mealLabel1.setBounds(550, 25, 300, 70);
                mealLabel1.setBackground(Color.decode("#752A00"));
                mealLabel1.setFont(new Font("Arial", Font.BOLD, 35));
                mealLabel1.setForeground(Color.decode("#FACD97"));
                mealLabel1.setFocusable(false);
                frame.add(mealLabel1);

                //Add Meal Name Label
                mealNameLabel.setText("Meal Name");
                mealNameLabel.setBounds(350, 130, 250, 30);
                mealNameLabel.setForeground(Color.decode("#331402"));
                mealNameLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.PLAIN, 20));
                frame.add(mealNameLabel);

                //Add Meal Name TextField
                mealNameTf.setBounds(350, 160, 300, 50);
                mealNameTf.setBackground(Color.white);
                frame.add(mealNameTf);

                //Add Description Label
                JLabel descriptionLabel = new JLabel("Description");
                descriptionLabel.setBounds(350, 230, 250, 30);
                descriptionLabel.setForeground(Color.decode("#331402"));
                descriptionLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.PLAIN, 20));
                frame.add(descriptionLabel);

                //Add Description TextField
                RoundedTextfield descriptionTf = new RoundedTextfield ();
                descriptionTf.setBounds(350, 260, 300, 50);
                descriptionTf.setBackground(Color.white);
                frame.add(descriptionTf);

                //Add Category Label
                JLabel categoryLabel = new JLabel("Category");
                categoryLabel.setBounds(350, 330, 250, 30);
                categoryLabel.setForeground(Color.decode("#331402"));
                categoryLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.PLAIN, 20));
                frame.add(categoryLabel);

                //Add Category Button
                breakfastButton.setBounds(350, 360, 90, 50);
                breakfastButton.setBackground(Color.white);
                breakfastButton.setForeground(Color.black);
                breakfastButton.setFocusable(false);
                breakfastButton.addActionListener(e3 -> {
                    breakfastButton.setBackground(Color.decode("#551F01"));
                    dinnerButton.setBackground(Color.white);
                    lunchButton.setBackground(Color.white);
                    breakfastButton.setForeground(Color.white);
                    lunchButton.setForeground(Color.black);
                    dinnerButton.setForeground(Color.black);
                    category = "breakfast";
                });
                frame.add(breakfastButton);
                lunchButton.setBounds(450, 360, 90, 50);
                lunchButton.setBackground(Color.white);
                lunchButton.setForeground(Color.black);
                lunchButton.setFocusable(false);
                lunchButton.addActionListener(e1 -> {
                    lunchButton.setBackground(Color.decode("#551F01"));
                    breakfastButton.setBackground(Color.white);
                    dinnerButton.setBackground(Color.white);
                    lunchButton.setForeground(Color.white);
                    breakfastButton.setForeground(Color.black);
                    dinnerButton.setForeground(Color.black);
                    category = "lunch";
                });
                frame.add(lunchButton);
                dinnerButton.setBounds(550, 360, 90, 50);
                dinnerButton.setBackground(Color.white);
                dinnerButton.setForeground(Color.black);
                dinnerButton.setFocusable(false);
                dinnerButton.addActionListener(e2 -> {
                    dinnerButton.setBackground(Color.decode("#551F01"));
                    breakfastButton.setBackground(Color.white);
                    lunchButton.setBackground(Color.white);
                    dinnerButton.setForeground(Color.white);
                    lunchButton.setForeground(Color.black);
                    breakfastButton.setForeground(Color.black);
                    category = "dinner";
                });
                frame.add(dinnerButton);

                //Add Ingredients Label
                JLabel ingredientsLabel = new JLabel("Ingredients");
                ingredientsLabel.setBounds(350, 430, 250, 30);
                ingredientsLabel.setForeground(Color.decode("#331402"));
                ingredientsLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.PLAIN, 20));
                frame.add(ingredientsLabel);

                //Add Ingredients TextField
                RoundedTextfield ingredientsTf = new RoundedTextfield();
                ingredientsTf.setBounds(350, 460, 300, 50);
                ingredientsTf.setBackground(Color.white);
                frame.add(ingredientsTf);

                //Add Diet Type Label
                JLabel dietTypeLabel = new JLabel("Diet Type");
                dietTypeLabel.setBounds(700, 130, 250, 30);
                dietTypeLabel.setForeground(Color.decode("#331402"));
                dietTypeLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.PLAIN, 20));
                frame.add(dietTypeLabel);

                //Add Diet Type buttons
                vegButton.setBounds(700, 160, 145, 50);
                vegButton.setBackground(Color.white);
                vegButton.setForeground(Color.black);
                vegButton.setFocusable(false);
                vegButton.addActionListener(e4 -> {
                    vegButton.setBackground(Color.decode("#551F01"));
                    nonvegButton.setBackground(Color.white);
                    vegButton.setForeground(Color.white);
                    nonvegButton.setForeground(Color.black);
                    dietType = "vegetarian";
                });
                frame.add(vegButton);
                nonvegButton.setBounds(860, 160, 145, 50);
                nonvegButton.setBackground(Color.white);
                nonvegButton.setForeground(Color.black);
                nonvegButton.setFocusable(false);
                nonvegButton.addActionListener(e8 -> {
                    nonvegButton.setBackground(Color.decode("#551F01"));
                    vegButton.setBackground(Color.white);
                    nonvegButton.setForeground(Color.white);
                    vegButton.setForeground(Color.black);
                    dietType = "non-vegetarian";
                });
                frame.add(nonvegButton);

                //Add Spice Type Label
                JLabel spiceTypeLabel = new JLabel("Spice Type");
                spiceTypeLabel.setBounds(700, 230, 250, 30);
                spiceTypeLabel.setForeground(Color.decode("#331402"));
                spiceTypeLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.PLAIN, 20));
                frame.add(spiceTypeLabel);

                //Add Spic Type Buttons
                spicyButton.setBounds(700, 260, 145, 50);
                spicyButton.setBackground(Color.white);
                spicyButton.setForeground(Color.black);
                spicyButton.setFocusable(false);
                spicyButton.addActionListener(e5 -> {
                    spicyButton.setBackground(Color.decode("#551F01"));
                    nonspicyButton.setBackground(Color.white);
                    spicyButton.setForeground(Color.white);
                    nonspicyButton.setForeground(Color.black);
                    spiceType = "spicy";
                });
                frame.add(spicyButton);
                nonspicyButton.setBounds(860, 260, 145,50);
                nonspicyButton.setBackground(Color.white);
                nonspicyButton.setForeground(Color.black);
                nonspicyButton.setFocusable(false);
                nonspicyButton.addActionListener(e6 -> {
                    nonspicyButton.setBackground(Color.decode("#551F01"));
                    spicyButton.setBackground(Color.white);
                    nonspicyButton.setForeground(Color.white);
                    spicyButton.setForeground(Color.black);
                    spiceType = "not-spicy";
                });
                frame.add(nonspicyButton);

                //Add Serving Size Label
                JLabel servingSizeLabel = new JLabel("Serving Size");
                servingSizeLabel.setBounds(700, 330, 250, 30);
                servingSizeLabel.setForeground(Color.decode("#331402"));
                servingSizeLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.PLAIN, 20));
                frame.add(servingSizeLabel);

                //Add Serving Size TextField
                RoundedTextfield servingSizeTf = new RoundedTextfield();
                servingSizeTf.setBounds(700, 360, 300, 50);
                servingSizeTf.setBackground(Color.white);
                frame.add(servingSizeTf);

                //Add Nutritional Value Label
                JLabel nutValueLabel = new JLabel("Nutritional Value ");
                nutValueLabel.setBounds(700, 430, 250, 30);
                nutValueLabel.setForeground(Color.decode("#331402"));
                nutValueLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.PLAIN, 20));
                frame.add(nutValueLabel);

                //Add Nutritional Value TextField
                RoundedTextfield nutValueTf = new RoundedTextfield();
                nutValueTf.setBounds(700, 460, 300, 50);
                nutValueTf.setBackground(Color.white);
                frame.add(nutValueTf);

                //Add Add Meal button
                addButton.setText("CONFIRM");
                addButton.setBounds(820, 530, 180, 45);
                addButton.setBackground(Color.decode("#551F01"));
                addButton.setFont(new Font("Arial", Font.BOLD, 14));
                addButton.setForeground(Color.white);
                addButton.setFocusable(false);
                addButton.setBorder(new RoundedBorder(50, Color.decode("#EF9B39")));
                addButton.addActionListener(e7 -> {
                    String mealName1 = mealNameTf.getText();
                    String description = descriptionTf.getText();
                    String ingredients = ingredientsTf.getText();
                    String diet = dietType;
                    String categ = category;
                    String spice = spiceType;
                    String serving = servingSizeTf.getText();
                    String nutVal = nutValueTf.getText();

                    mealsDatabase.updateMeals(mealName1, description, categ, ingredients,diet, spice, serving, nutVal);
                    new ConfirmPage(frame);
                });
                frame.add(addButton);

            } else {
                error.setBounds(630, 320, 500, 50);
                error.setForeground(Color.red);
                error.setFont(new Font("Arial", Font.BOLD, 20));
            }
        });
        frame.add(error);
        frame.add(button);
        frame.setVisible(true);
    }

    public void deleteMeal(JFrame frame) {

        new MealSidePanel(frame);

        RoundedButton meallLabel = new RoundedButton("DELETE MEAL");
        meallLabel.setBounds(550, 25, 300, 70);
        meallLabel.setBackground(Color.decode("#752A00"));
        meallLabel.setFont(new Font("Arial", Font.BOLD, 35));
        meallLabel.setForeground(Color.decode("#FACD97"));
        meallLabel.setFocusable(false);
        frame.add(meallLabel);

        JLabel label = new JLabel("Enter the Name or Id of the meal you would like to delete:");
        label.setBounds(400, 200, 1000, 50);
        label.setForeground(Color.decode("#331402"));
        label.setFont(new Font("Arial", Font.PLAIN, 26));
        frame.add(label);

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
                String meal = textField.getText();

            if (meal.isEmpty()){
                error.setBounds(630, 320, 500, 50);
                error.setForeground(Color.red);
                error.setFont(new Font("Arial", Font.BOLD, 20));
                frame.add(error);
                frame.repaint();
            } else if (isNumeric(meal)) {
                int mealId = Integer.parseInt(meal);
                mealsDatabase.deleteMeal(mealId);
                frame.getContentPane().removeAll();
                new ConfirmPage(frame);
                frame.revalidate();
                frame.repaint();
            } else {
                mealsDatabase.deleteMealByName(meal);
                frame.getContentPane().removeAll();
                new ConfirmPage(frame);
                frame.revalidate();
                frame.repaint();

            }
        });
        frame.add(error);
        frame.add(button);
        frame.setVisible(true);
    }
}