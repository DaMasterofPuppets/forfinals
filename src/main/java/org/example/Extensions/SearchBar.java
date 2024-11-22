package org.example.Extensions;

import org.example.Databases.mealsDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBar {

    public SearchBar(JFrame frame) {
        RoundedTextfield searchbar = new RoundedTextfield();
        searchbar.setBounds(370, 20, 550, 45);
        searchbar.setBackground(Color.decode("#FACD97"));
        searchbar.setForeground(Color.black);
        searchbar.setCaretPosition(moveCaretRight(searchbar));
        frame.add(searchbar);

        String searchName = searchbar.getText();

        ImageIcon img = new ImageIcon("src/main/java/org/example/img/Search.png");
        JButton search = new JButton(img);
        search.setBorder(BorderFactory.createEmptyBorder());
        search.setFocusable(false);
        search.setBackground(Color.decode("#FACD97"));
        search.setBounds(9, 2, 30, 40);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mealsDatabase.getSearchedMeals(searchName);
            }
        });
        searchbar.add(search);
    }

    private static int moveCaretRight(JTextField textField) {
        int currentCaretPos = textField.getCaretPosition();
        int newCaretPos = currentCaretPos + 10;
        newCaretPos = Math.min(newCaretPos, textField.getText().length());
        textField.setCaretPosition(newCaretPos);
        return newCaretPos;
    }
}
