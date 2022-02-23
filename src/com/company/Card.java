package com.company;

public class Card {
    private String term;
    private String definition;
    public Card() {
        this.term = new String();
        this.definition = new String();
    }
    public Card(String t, String d) {
        this.term = t;
        this.definition = d;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public boolean correctDefinition(String input) {
        return this.definition.equals(input);
    }
    public static Card readCard(String line) {
        String[] s = line.split(" - ");
        String term = s[0];
        String definition = s[1];
        return new Card(term, definition);
    }
    @Override
    public String toString() {
        return this.term+" - "+this.definition;
    }
}
