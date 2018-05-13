package com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Brudnopis {
    private List<String> snapShots;
    private Integer nr = 0;
    private Integer undoCount = 0;

    Brudnopis() {
        snapShots = Arrays.asList("", "", "", "", "", "", "", "", "", "");
        //snapShots.add("");
        //snapShots.add("");
        //snapShots.add("");
    }

    public void wypisz() {
        System.out.println("0: " + snapShots.get(0));
        System.out.println("1: " + snapShots.get(1));
        System.out.println("2: " + snapShots.get(2));
    }

    public String getState() {
        return snapShots.get(nr);
    }

    public void newState(String str) {
        undoCount = 0;
        nr = (nr + 1) % 10;
        snapShots.set(nr, str);
    }

    public void prevState() {
        nr = (nr - 1) % 10;
        undoCount++;
    }

    public void nextState() {
        if(undoCount > 0){
            nr = (nr + 1) % 10;
            undoCount--;
        }
    }
}
