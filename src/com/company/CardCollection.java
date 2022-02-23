package com.company;

import java.util.ArrayList;
import java.util.Optional;

public class CardCollection {
    private ArrayList<Set> sets;
    public CardCollection() {
        this.sets = new ArrayList<>();
    }
    public void addSet(Set s) {
        this.sets.add(s);
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < sets.size(); i++) {
            str.append(this.sets.get(i).toString());
            if ( i < sets.size() - 1) {
                str.append("\n");
            }
        }
        return str.toString();
    }

    public ArrayList<Set> getSets() {
        return sets;
    }
    public Set getSet(String option) {
        Optional<Set> s = this.sets.stream().filter(set -> set.getName().equals(option)).findAny();
        if (s.isEmpty()) {
            return sets.get(0);
        }
        return s.get();
    }
}
