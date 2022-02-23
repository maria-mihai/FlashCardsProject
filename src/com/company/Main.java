package com.company;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import javax.swing.*;
public class Main {


        /**
     * Modes:
     * Main page: ADD (Button), LEARN (Button), REVISE (Button)
     * Add Set: NAME (Field), ADD_BUTTON (Button), BACK (Button)
     * Add Card: SET (Field), TERM (Field), DEFINITION (Button), ADD_CARD (Button), BACK (Button)
     * Learn: TERM (Field), DEFINITION (Field), REVEAL (Button), BACK (Button)
     * Revise: TERM (Field), INPUT (Field), ACTUAL (Field), CHECK (Button), MESSAGE (Label), BACK (Button)
     *
     */
    public static void main(String[] args) {
	CardCollection c = new CardCollection();
    Set lastSet = null;
    try (Scanner sc = new Scanner(new File("resources/cards.txt"))) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.length() > 0) {
                if (line.startsWith("SET")) {
                    lastSet = Set.readSet(line);
                    c.addSet(lastSet);
                } else {
                    lastSet.add(Card.readCard(line));
                }
            }
        }
        FlashCardGUI gui = new FlashCardGUI();
        gui.display(c);
    }
    catch (FileNotFoundException e) {
        e.printStackTrace();
        }
    }

}
