package com;

import java.util.Scanner;

import static java.lang.System.exit;

public class Driver {
    private Brudnopis brudnopis = new Brudnopis();
    private boolean notify = false;

    Driver() {
        Thread t = new Thread(new SaveLoop());
        t.start();
    }

    public void save() {
        Scanner scanner = new Scanner(System.in);
        String continuation = scanner.nextLine();

        if(continuation.equals("q")){
            exit(0);
        }

        String currentState = brudnopis.getState();

        StringBuilder builder = new StringBuilder();
        builder.append(currentState);

        builder.append("\n");
        builder.append(continuation);

        String newstr = builder.toString();

        brudnopis.newState(newstr);

        notify = true;
    }

    public String returnToPreviousState() {
        brudnopis.prevState();
        return brudnopis.getState();
    }

    public String nextState() {
        brudnopis.nextState();
        return brudnopis.getState();
    }

    public void currentState() {
        System.out.println(brudnopis.getState());
    }

    class SaveLoop implements Runnable {
        @Override
        public void run() {
            while (true) {
                if(notify) {
                    notify = false;
                    //String str = new String(brudnopis.getState(1));
                    //brudnopis.changeState(0, str);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException occurred");
                    e.printStackTrace();
                }
            }
        }
    }
}
