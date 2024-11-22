package org.example;

import org.example.Extensions.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConfirmPage extends JPanel {

    ConfirmPage (JFrame frame) {

        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(150, 70, 800, 400);
        panel.setBackground(Color.white);
        panel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        frame.add(panel);

        ImageIcon img = new ImageIcon("src/main/java/org/example/confirm.png");
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, 310, 400);
        panel.add(imgLabel);

        JLabel label1 = new JLabel("MEAL");
        label1.setBounds(370, 110, 1000, 100);
        label1.setFont(new Font("Arial", Font.BOLD, 100));
        label1.setForeground(Color.decode("#551F01"));
        panel.add(label1);

        JLabel label2 = new JLabel("CREATED!");
        label2.setBounds(260, 210, 1000, 100);
        label2.setFont(new Font("Arial", Font.BOLD, 100));
        label2.setForeground(Color.decode("#551F01"));
        panel.add(label2);

        RoundedButton button = new  RoundedButton("CONFIRM");
        button.setBounds(450, 330, 150, 50);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setFocusable(false);
        button.setBorderThickness(0);
        button.setBackground(Color.decode("#551F01"));
        button.setForeground(Color.white);
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
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MealEditorPage(frame);
            }
        });
        panel.add(button);
    }
}
