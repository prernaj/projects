package com.example.thread_synchronized;

public class Sender3 {
    public void send(String msg) {
        synchronized(this) {
            System.out.println("Sending\t" + msg );
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Thread interrupted.");
            }
            System.out.println("\n" + msg + "Sent");
        }
    }
}
