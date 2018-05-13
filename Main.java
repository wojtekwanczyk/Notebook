package com;

import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import sun.misc.Signal;
import sun.misc.SignalHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static java.awt.event.ActionEvent.CTRL_MASK;
import static java.awt.event.KeyEvent.VK_V;

public class Main {
    protected static Driver driver = new Driver();
    public static void main(String[] args) {
        System.out.println("\nWelcome to simple notebook!\n");
        DebugSignalHandler.listenTo("TSTP");
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