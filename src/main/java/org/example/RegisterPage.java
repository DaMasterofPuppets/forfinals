package org.example;

import org.example.Databases.usersDatabase;
import org.example.Extensions.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterPage {

    String role = "Manager";

    RegisterPage(JFrame frame) {

        frame.setTitle("Register");  //set the title of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //close the application when the window is closed

        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#EF9B39"));

        //Back to Login Button
        RoundedButton loginButton = new RoundedButton("LogIn");
        loginButton.setBorderThickness(2);
        loginButton.setBorderColor(Color.decode("#331402"));
        loginButton.setBounds(270, 415, 120, 45);
        loginButton.setBackground(Color.white);
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        loginButton.setForeground(Color.decode("#331402"));
        loginButton.setFocusable(false);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                new LoginPage(frame);
                frame.revalidate();
                frame.repaint();
            }
        });
        frame.add(loginButton);

        //Create Account Label
        JLabel label = new JLabel("CREATE ACCOUNT");
        label.setBounds(45, 80, 500, 100);
        label.setFont(new Font("Arial", Font.BOLD, 50));
        label.setForeground(Color.decode("#752A00"));
        frame.add(label);

        //Username Label
        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(45, 150, 500, 100);
        userLabel.setFont(new Font("Arial", Font.BOLD, 24));
        userLabel.setForeground(Color.decode("#752A00"));
        frame.add(userLabel);

        //Username Textfield
        JTextField username = new JTextField();
        username.setBounds(45, 215, 470, 57);
        username.setBorder(BorderFactory.createEmptyBorder());
        username.setBackground(Color.white);
        frame.add(username);

        //Password Label
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(45, 260, 500, 100);
        passLabel.setFont(new Font("Arial", Font.BOLD, 24));
        passLabel.setForeground(Color.decode("#752A00"));
        frame.add(passLabel);

        //Password Textfield
        JPasswordField password = new JPasswordField();
        password.setBounds(44, 325, 470, 57);
        password.setBorder(BorderFactory.createEmptyBorder());
        password.setBackground(Color.white);
        frame.add(password);

        //Add image
        ImageIcon img = new ImageIcon("src/main/java/org/example/img/register.png");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(520, -10, 575, 600);
        frame.add(imgLabel);

        //Register Button
        JButton registerButton = new JButton("REGISTER");
        registerButton.setBounds(45, 415, 175, 45);
        registerButton.setBackground(Color.white);
        registerButton.setBorder(BorderFactory.createLineBorder(Color.decode("#331402"), 2));
        registerButton.setFont(new Font("Arial", Font.BOLD, 20));
        registerButton.setFocusable(false);
        registerButton.addActionListener(e -> {
            String userName = username.getText();
            String passWord = new String(password.getPassword());

            if(userName.isEmpty()||passWord.isEmpty()) {
                JLabel errorLabel = new JLabel("Fields cannot be empty");
                errorLabel.setBounds(180, 370, 1000, 50);
                errorLabel.setFont(new Font("Arial", Font.BOLD, 16));
                errorLabel.setForeground(Color.red);
                frame.add(errorLabel);
                frame.revalidate();
                frame.repaint();
                return;
            } else if(!usersDatabase.isUsernameAvailable(userName)){
                JLabel errorLabel = new JLabel("Username already exists. Please choose another");
                errorLabel.setBounds(100, 370, 1000, 50);
                errorLabel.setFont(new Font("Arial", Font.BOLD, 16));
                errorLabel.setForeground(Color.red);
                frame.add(errorLabel);
                frame.revalidate();
                frame.repaint();
                return;
                }

            usersDatabase.registerUser(userName, passWord, role);

            username.setText("");
            password.setText("");

            frame.getContentPane().removeAll();
            new RoleSelectionPage(frame);
            frame.revalidate();
            frame.repaint();
        });
        frame.add(registerButton);

        frame.setResizable(false);
        frame.setVisible(true);
    }
}
