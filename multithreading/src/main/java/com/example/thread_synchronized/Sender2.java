package com.example.thread_synchronized;

public class Sender2 {
    public synchronized void send(String msg) {
        System.out.println("Sending\t" + msg );
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("\n" + msg + "Sent");
    }
}
