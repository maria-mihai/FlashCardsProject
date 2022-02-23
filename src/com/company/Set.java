package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Set {
    private String name;
    private ArrayList<Card> set;
    public Set(String name) {
        this.name = name;
        this.set = new ArrayList<>();
    }
    public Set() {
        this.name = null;
        this.set = new ArrayList<>();
    }
    public void add(Card c) {
        this.set.add(c);
    }
    public static Set readSet(String line) {
        String[] s = line.split(" ");
        return new Set(s[1]);
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("SET "+this.name+"\n");
        for (int i = 0; i < this.set.size(); i++) {
            str.append(this.set.get(i).toString()+"\n");
        }
        return str.toString();
    }
    public  Card getRandomCard() {
        Random r = new Random();
        int index = r.nextInt(set.size());
        return set.get(index);
    }
    public String getName() {
        return this.name;
    }
    public void setName(String nm) {
        this.name = nm;
    }

}
