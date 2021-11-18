package com.example.summary;

public class PrintTestSyncBlock extends Thread {
    public synchronized void printThread(int n) {
        synchronized(this) {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Thread " + n + " is working...");
                try {
                    Thread.sleep(600);
                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }
            }
        }
            
        System.out.println("--------------------------");
            
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
