package com.example.lifecycle_and_state;

public class thread implements Runnable {
    public void run() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of thread1 while it called join() method on thread2 -" + Test.thread1.getState());
    }
}
