package com;

import java.util.Scanner;

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

        String currentState = brudnopis.getState();

        StringBuilder builder = new StringBuilder();
        builder.append(currentState);

        builder.append("\n");
        builder.append(continuation);

        String newstr = builder.toString();

        brudnopis.newState(newstr);

        notify = true;
    }

    public void returnToPreviousState() {
        brudnopis.prevState();
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
