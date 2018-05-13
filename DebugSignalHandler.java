package com;

import sun.misc.Signal;
import sun.misc.SignalHandler;

class DebugSignalHandler implements SignalHandler
{
    static void listenTo(String name) {
        Signal signal = new Signal(name);
        Signal.handle(signal, new DebugSignalHandler());
    }

    public void handle(Signal signal) {
        if (signal.toString().trim().equals("SIGTSTP")) {
            System.out.println("\nReturning to previous point(UNDO)");
            String s = Main.driver.returnToPreviousState();
            System.out.println(s);
        }
        if (signal.toString().trim().equals("SIGINT")) {
            System.out.println("\nRestore point (REDO)");
            String s = Main.driver.nextState();
            System.out.println(s);
            //System.exit(0);
        }
    }
}