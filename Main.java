package com;

import java.util.Scanner;
import java.util.Timer;

public class Main {
    static Driver driver = new Driver();

    public static void main(String[] args) {
        System.out.println("\nWelcome to simple notebook!\n");
        DebugSignalHandler.listenTo("TSTP");
        DebugSignalHandler.listenTo("INT");

        Timer timer = new Timer();
        timer.schedule(new Updater(driver), 0, 100);


        while (true) {

        }
    }
}


