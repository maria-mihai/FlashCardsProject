package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FlashCardGUI implements ItemListener {
    JFrame frame;
    final static String LEARNPANEL = "Learn";
    final static String REVISEPANEL = "Revise";
    final static String CHOOSESET = "Choose set";
    final static String ADDCARD = "Add card";
    private JPanel cards;
    JPanel cardLEARN;
    JPanel cardREVISE;
    JPanel cardCHOOSE;
    JPanel cardADD;
    static Set currentSet;


    public void addComponentsToFrame(Container pane, CardCollection c) {
        currentSet = c.getSets().get(0);
        cardCHOOSE = ChoosePanel.choosePage(c);
        cardLEARN = LearnPanel.learnPage();
        cardREVISE = RevisePanel.revisePage();
        cardADD = AddPanel.addCardPage(c);
        cards = new JPanel(new CardLayout(4,100));
        cards.setSize(400,400);
        cards.add(cardLEARN, LEARNPANEL);
        cards.add(cardREVISE, REVISEPANEL);
        cards.add(cardCHOOSE, CHOOSESET);
        cards.add(cardADD, ADDCARD);
        JPanel comboBoxPane = new JPanel();
        String[] comboBoxItems = {LEARNPANEL,REVISEPANEL,CHOOSESET,ADDCARD};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);


        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
    public static void setCurrentSet(Set s) {
        currentSet = s;
    }
    public static Set getCurrentSet() {
        return currentSet;
    }
    public void display(CardCollection c) {
        JFrame frame = new JFrame("FlashCards");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlashCardGUI gui = new FlashCardGUI();
        gui.addComponentsToFrame(frame.getContentPane(), c);
        frame.pack();
        frame.setVisible(true);
    }
}
