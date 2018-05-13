package com;

import sun.misc.Signal;
import sun.misc.SignalHandler;

public class Main {
    protected static Driver driver = new Driver();
    public static void main(String[] args) {
        //DebugSignalHandler.listenTo("TSTP");
        DebugSignalHandler.listenTo("INT");
        while(true) {
            driver.save();
            driver.currentState();
        }
    }
}

class DebugSignalHandler implements SignalHandler
{
    public static void listenTo(String name) {
        Signal signal = new Signal(name);
        Signal.handle(signal, new DebugSignalHandler());
    }

    public void handle(Signal signal) {
        if (signal.toString().trim().equals("SIGTSTP")) {
            System.out.println("\nReturning to previous point");
            Main.driver.returnToPreviousState();
        }
        if (signal.toString().trim().equals("SIGINT")) {
            System.out.println("\nEnding program...");
            System.exit(0);
        }
    }
}