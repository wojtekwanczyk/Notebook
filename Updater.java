package com;

import java.util.TimerTask;

public class Updater extends TimerTask {
    private Driver d;

    Updater(Driver d){
        this.d = d;
    }
    public void run() {
        //System.out.println("Pobieram dane!\n");
        d.update();
        d.currentState();
    }
}


