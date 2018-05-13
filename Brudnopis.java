package com;

import java.util.Arrays;
import java.util.List;

class Brudnopis {
    private List<String> snapShots;
    private Integer nr = 0;
    private int undoCount = 0;

    Brudnopis() {
        snapShots = Arrays.asList("", "", "", "", "", "", "", "", "", "");
    }

    String getState() {
        return snapShots.get(nr);
    }

    void newState(String str) {
        undoCount = 0;
        nr = (nr + 1) % 10;
        snapShots.set(nr, str);
    }

    void prevState() {
        if(undoCount == 9) {
            System.out.println("Cannot UNDO anymore!\n");
            return;
        }
        nr = (nr - 1) % 10;
        if(nr == -1)
            nr = 9;
        undoCount++;
    }

    void nextState() {
        if(undoCount > 0){
            nr = (nr + 1) % 10;
            undoCount--;
        }else{
            System.out.println("Cannot REDO anymore!\n");
        }
    }
}
