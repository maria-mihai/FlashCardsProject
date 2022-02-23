package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RevisePanel {
    static JPanel cardRevise;
    static Card crnt;
    static JButton checkButton;
    static JButton nextButton;
    static JTextField input;
    static JLabel term;
    static Set set;
    static JLabel message;
    public static JPanel revisePage() {
        set = FlashCardGUI.getCurrentSet();
        cardRevise = new JPanel();
        cardRevise.setSize(400,400);
        crnt = set.getRandomCard();
        term = new JLabel(crnt.getTerm());
        cardRevise.add(term);
        input = new JTextField(20);
        cardRevise.add(input);
        checkButton = new JButton("Check");
        nextButton = new JButton("Next");
        setUpButtonListeners();
        cardRevise.add(checkButton);
        cardRevise.add(nextButton);
        message = new JLabel("");
        cardRevise.add(nextButton);
        cardRevise.add(message);
        return cardRevise;
    }

    public static void setUpButtonListeners() {
        ActionListener checkListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = input.getText();
                if (crnt.correctDefinition(s)) {
                    message.setForeground(Color.green);
                    message.setText("Great job!");
                }
                else {
                    message.setForeground(Color.red);
                    message.setText("Incorrect. Please try again!");
                }
            }
        };
        checkButton.addActionListener(checkListener);
        ActionListener nextListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                input.setText("");
                set = FlashCardGUI.getCurrentSet();
                crnt = set.getRandomCard();
                term.setText(crnt.getTerm());
                message.setText("");
                cardRevise.setForeground(Color.black);
            }
        };
        nextButton.addActionListener(nextListener);
    }
}
