package org.example;

import org.example.Databases.usersDatabase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LoginPage {
    public LoginPage(JFrame frame) {

        JLabel errorLabel = new JLabel();

        //Create Frame
        frame.setSize(1100, 600);
        frame.getContentPane().setBackground(Color.decode("#EF9B39"));
        frame.setLayout(null);
        frame.setLocationRelativeTo((Component) null);
        frame.setResizable(false);

        frame.setTitle("Login");  //set the title of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //close the application when the window is closed

        ImageIcon img = new ImageIcon("src/main/java/org/example/img/logo.png");
        JLabel image = new JLabel(img);
        image.setBounds(0, 0, 450, 600);
        frame.add(image);

        //Create Login Label
        JLabel label = new JLabel();
        label.setText("EMPLOYEE LOGIN");
        label.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 60));
        label.setForeground(Color.decode("#752A00"));
        label.setBounds(440, 78, 1000, 70);
        frame.add(label);

        //Create Username Label
        JLabel userLabel = new JLabel("Username");
        userLabel.setForeground(Color.decode("#752A00"));
        userLabel.setBounds(445, 190, 200, 50);
        userLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(userLabel);

        //Create Username Field
        JTextField userName = new JTextField();
        userName.setBorder(BorderFactory.createEmptyBorder());
        userName.setBounds(445, 230, 592, 57);
        userName.setFont(new Font("Arial", Font.BOLD, 20));
        userName.setCaretColor(Color.darkGray);
        frame.add(userName);

        //Create password Label
        JLabel passLabel = new JLabel("Password");
        passLabel.setForeground(Color.decode("#752A00"));
        passLabel.setBounds(445, 310, 200, 50);
        passLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(passLabel);

        //Create Password Field
        JPasswordField password = new JPasswordField();
        password.setBorder(BorderFactory.createEmptyBorder());
        password.setBounds(445, 350, 592, 57);
        password.setFont(new Font("Arial", Font.BOLD, 20));
        password.setForeground(Color. darkGray);
        password.setCaretColor(Color.darkGray);
        frame.add(password);

        //Create Login Button
        JButton loginButton = new JButton();
        loginButton.setBounds(930, 450, 108, 40);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.decode("#331402"), 3));
        loginButton.setBackground(Color.white);
        loginButton.setText("enter");
        loginButton.setForeground(Color.decode("#551F01"));
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.setFocusable(false);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usernameInput = userName.getText();
                String passwordInput = new String(password.getPassword());

                if (usersDatabase.authenticateUser(usernameInput, passwordInput)) {
                    new MenuPage(frame);
                } else {
                    //Create Error Login Label
                    errorLabel.setText("Invalid username and password. Please try again");
                    errorLabel.setBounds(550, 420, 500, 20);
                    errorLabel.setForeground(Color.red);
                    errorLabel.setFont(new Font("Bitstream Vera Sans Mono", Font.BOLD, 14));
                    userName.setText("");
                    password.setText("");
                }

            }
        });
        frame.add(errorLabel);
        frame.add(loginButton);

        //Create Register Label
        JLabel label2 = new JLabel();
        label2.setText("Don't have an account yet? ");
        label2.setBounds(550, 425, 500, 100);
        label2.setFont(new Font("Bitstream Vera Sans Mono", Font.BOLD, 16));
        label2.setForeground(Color.decode("#752A00"));
        frame.add(label2);

        //Create Register button
        JButton registerButton = new JButton();
        registerButton.setText("Register");
        registerButton.setFont(new Font("Bitstream Vera Sans Mono", Font.BOLD, 16));
        registerButton.setForeground(Color.BLUE);
        registerButton.setForeground(Color.decode("#752A00"));
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setFocusPainted(false);
        registerButton.setBounds(748, 455, 100, 40);
        registerButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                frame.getContentPane().removeAll();
                new RegisterPage(frame);
                frame.revalidate();
                frame.repaint();
            }
            public void mouseEntered(MouseEvent e) {
                registerButton.setForeground(Color.BLUE);
            }
            public void mouseExited(MouseEvent e) {
                registerButton.setForeground(Color.decode("#752A00"));
            }
        });

        frame.add(registerButton);
        frame.setVisible(true);
    }


}

