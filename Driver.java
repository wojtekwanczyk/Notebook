package com;

import java.util.Scanner;

import static java.lang.System.exit;

class Driver {
    private Brudnopis brudnopis = new Brudnopis();
    private Scanner scanner = new Scanner(System.in);

    void update() {

        String currentState = brudnopis.getState();
        StringBuilder builder = new StringBuilder();
        builder.append(currentState);
        String next;

        next = scanner.nextLine();

        if(next.equals("q")){
            exit(0);
        }

        builder.append("\n");
        builder.append(next);

        String newStr = builder.toString();

        brudnopis.newState(newStr);
    }


    String returnToPreviousState() {
        brudnopis.prevState();
        return brudnopis.getState();
    }

    String nextState() {
        brudnopis.nextState();
        return brudnopis.getState();
    }

    void currentState() {
        System.out.println(brudnopis.getState());
    }



}
