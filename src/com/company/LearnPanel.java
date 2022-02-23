package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LearnPanel {
    static JPanel cardLEARN;
    static Card crnt;
    static JLabel def;
    static JButton buttonSHOW;
    static JButton buttonNEXT;
    static Set set;
    static JLabel term;
    public static JPanel learnPage() {
        set = FlashCardGUI.getCurrentSet();
        cardLEARN = new JPanel();
        crnt = set.getRandomCard();
        term = new JLabel(crnt.getTerm());
        cardLEARN.add(term);
        def = new JLabel("");
        cardLEARN.add(def);
        buttonSHOW = new JButton("Show");
        buttonNEXT = new JButton("Next");
        setUpButtonListeners();
        cardLEARN.add(buttonSHOW);
        cardLEARN.add(buttonNEXT);
        return cardLEARN;
    }
    public static void setUpButtonListeners() {
        ActionListener showListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                def.setText(" = "+crnt.getDefinition());
            }
        };
        buttonSHOW.addActionListener(showListener);
        ActionListener nextListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                set = FlashCardGUI.getCurrentSet();
                crnt = set.getRandomCard();
                term.setText(crnt.getTerm());
                def.setText("");
            }
        };
        buttonNEXT.addActionListener(nextListener);
    }


}
