package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoosePanel {
    static JComboBox<String> comboSets;
    static JLabel message;
    static JPanel cardCHOOSE;
    static Set crntSet;
    public static JPanel choosePage(CardCollection c) {
        cardCHOOSE = new JPanel();
        Object[] comboBoxItems = c.getSets().stream().map(s -> s.getName()).toArray();
        comboSets = new JComboBox(comboBoxItems);
        getSet(c);
        message = new JLabel("What do you want to practice?");
        cardCHOOSE.add(message);
        cardCHOOSE.add(comboSets);
        return cardCHOOSE;
    }
    public static void getSet(CardCollection c) {
        ItemListener chooseListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                FlashCardGUI.setCurrentSet(c.getSet((String) e.getItem()));
            }
        };
        comboSets.addItemListener(chooseListener);
    }

}
