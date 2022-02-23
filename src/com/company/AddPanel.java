package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class AddPanel {
    static JPanel cardAdd;
    static CardCollection coll;
    static JComboBox<String> sets;
    static JTextField term;
    static JTextField def;
    static JRadioButton newSetAdded;
    static JTextField newSet;
    static JButton done;

    public static JPanel addCardPage(CardCollection c) {
        cardAdd = new JPanel();
        Object[] comboBoxItems = c.getSets().stream().map(s -> s.getName()).toArray();
        sets = new JComboBox(comboBoxItems);
        cardAdd.add(sets);
        coll = c;
        term = new JTextField("Term",20);
        def = new JTextField("Definition",20);
        newSetAdded = new JRadioButton("Add new set?");
        newSet = new JTextField("New Set",20);
        done = new JButton("Done");
        setUp(c);
        cardAdd.add(term);
        cardAdd.add(def);
        cardAdd.add(newSetAdded);
        cardAdd.add(newSet);
        cardAdd.add(done);
        return cardAdd;
    }
    public static void setUp(CardCollection c) {
        ActionListener listenForDone = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                if (newSetAdded.isSelected()) {
                    Set s = new Set();
                    s.setName(newSet.getText());
                    s.add(new Card(term.getText(), def.getText()));
                    c.addSet(s);
                    try (PrintWriter pw = new PrintWriter("resources/cards.txt")) {
                        pw.print(c.toString());
                        pw.flush();
                    }
                    catch(Exception ex) {
                        ex.printStackTrace();
                    }

                }
                else {
                    Set s = c.getSet((String) sets.getSelectedItem());
                    s.add(new Card(term.getText(), def.getText()));
                    try (PrintWriter pw = new PrintWriter("resources/cards.txt")) {
                        pw.print(c.toString());
                        pw.flush();
                    }
                    catch(Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        done.addActionListener(listenForDone);
    }
}
