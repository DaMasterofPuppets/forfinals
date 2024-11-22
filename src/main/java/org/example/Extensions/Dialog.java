package org.example.Extensions;

import javax.swing.*;
import java.awt.*;

public class Dialog extends JDialog {

    public Dialog(String[] meal, JFrame frame) {
        JDialog dialog = new JDialog();

        dialog.setSize(300,370);
        dialog.getContentPane().setBackground(Color.decode("#331402"));
        dialog.setLocationRelativeTo(frame);
        dialog.setLayout(null);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            //Create Panel
            JPanel namePanel = new JPanel();
            namePanel.setBounds(0, 150, 300, 40);
            namePanel.setBackground(Color.white);
            dialog.add(namePanel);

            JLabel nameLabel = new JLabel(meal[0]);
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            nameLabel.setForeground(Color.decode("#EF9B39"));
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 27));
            namePanel.add(nameLabel);

            JLabel id = new JLabel(meal[1]);
            id.setBounds(10, 105, 300, 50);
            id.setForeground(Color.decode("#EF9B39"));
            id.setFont(new Font("Arial", Font.PLAIN, 18));
            dialog.add(id);

            JLabel descriptionLabel = new JLabel(meal[2]);
            descriptionLabel.setBounds(0, 182, 300, 50);
            descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
            descriptionLabel.setForeground(Color.decode("#EF9B39"));
            descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            dialog.add(descriptionLabel);

            JLabel nutValue = new JLabel(meal[3] + " calories");
            nutValue.setBounds(0, 205, 300, 50);
            nutValue.setHorizontalAlignment(SwingConstants.CENTER);
            nutValue.setForeground(Color.decode("#EF9B39"));
            nutValue.setFont(new Font("Arial", Font.PLAIN, 18));
            dialog.add(nutValue);

            JLabel spiceLabel = new JLabel(meal[4]);
            spiceLabel.setBounds(0, 265, 300, 50);
            spiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            spiceLabel.setForeground(Color.decode("#EF9B39"));
            spiceLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            dialog.add(spiceLabel);

            JLabel servSize = new JLabel(meal[5]);
            servSize.setBounds(0, 225, 300, 50);
            servSize.setHorizontalAlignment(SwingConstants.CENTER);
            servSize.setForeground(Color.decode("#EF9B39"));
            servSize.setFont(new Font("Arial", Font.PLAIN, 18));
            dialog.add(servSize);

            JLabel dietLabel = new JLabel(meal[6]);
            dietLabel.setBounds(0, 245, 300, 50);
            dietLabel.setHorizontalAlignment(SwingConstants.CENTER);
            dietLabel.setForeground(Color.decode("#EF9B39"));
            dietLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            dialog.add(dietLabel);

            JLabel ingredientsLabel = new JLabel(meal[7]);
            ingredientsLabel.setBounds(0, 285, 300, 50);
            ingredientsLabel.setHorizontalAlignment(SwingConstants.CENTER);
            ingredientsLabel.setForeground(Color.decode("#EF9B39"));
            ingredientsLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            dialog.add(ingredientsLabel);

        dialog.setVisible(true);
    }
}
