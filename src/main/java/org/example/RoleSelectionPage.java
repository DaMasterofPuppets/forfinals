package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoleSelectionPage {
    String role = "worker";

    //labels
    JLabel roleSelectionLabel = new JLabel();
    JLabel selectChoicesLabel = new JLabel();

    //buttons
    JButton managerButton = new JButton();
    JButton employeeButton = new JButton();

    RoleSelectionPage(JFrame frame) {

        frame.setTitle("Role Selection");  //set the title of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //close the application when the window is closed

        frame.setLayout(null);

        ImageIcon img = new ImageIcon("src/main/java/org/example/img/logo.png");
        JLabel image = new JLabel(img);
        image.setBounds(0, 0, 450, 600);
        frame.add(image);

        //role selection label
        roleSelectionLabel.setText("ROLE SELECTION");
        roleSelectionLabel.setBounds(450, 90, 900, 100);
        roleSelectionLabel.setFont(new Font("Arial", Font.PLAIN, 70));
        roleSelectionLabel.setForeground(Color.decode("#752A00"));
        frame.add(roleSelectionLabel);

        //select choices label
        selectChoicesLabel.setText("Hello! Kindly select your role from the choices below:");
        selectChoicesLabel.setBounds(500, 150, 900, 100);
        selectChoicesLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        selectChoicesLabel.setForeground(Color.decode("#752A00"));
        frame.add(selectChoicesLabel);

        // manager button
        managerButton.setBounds(600, 250, 300, 40);
        managerButton.setBackground(Color.decode("#FFFFFF"));
        managerButton.setText("MANAGER");
        managerButton.setFont(new Font("Arial", Font.BOLD, 18));
        managerButton.setForeground(new Color(0xFF752A00));
        managerButton.setFocusable(false);
        managerButton.setBorderPainted(false);  // Disable the border
        managerButton.setFocusPainted(false);   // Disable the focus border
        managerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new MenuPage(frame);  // Navigate to Manager Page
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(managerButton);

        // employee button
        employeeButton.setBounds(600, 310, 300, 40);
        employeeButton.setBackground(Color.decode("#FFFFFF"));
        employeeButton.setText("EMPLOYEE");
        employeeButton.setFont(new Font("Arial", Font.BOLD, 18));
        employeeButton.setForeground(new Color(0xFF752A00));
        employeeButton.setFocusable(false);
        employeeButton.setBorderPainted(false);  // Disable the border
        employeeButton.setFocusPainted(false);   // Disable the focus border
        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new MenuPage(frame);  // Navigate to Employee Page
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(employeeButton);
    }
}

