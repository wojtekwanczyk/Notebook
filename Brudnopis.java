package com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Brudnopis {
    private List<String> snapShots;
    private Integer nr = 0;
    private int undoCount = 0;

    Brudnopis() {
        snapShots = Arrays.asList("", "", "", "", "", "", "", "", "", "");
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
        if(undoCount == 9) {
            System.out.println("Cannot UNDO anymore!\n");
            return;
        }
        nr = (nr - 1) % 10;
        if(nr == -1)
            nr = 9;
        undoCount++;
    }

    public void nextState() {
        if(undoCount > 0){
            nr = (nr + 1) % 10;
            undoCount--;
        }else{
            System.out.println("Cannot REDO anymore!\n");
        }
    }
}
