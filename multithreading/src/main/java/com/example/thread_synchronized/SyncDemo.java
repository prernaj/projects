package com.example.thread_synchronized;

public class SyncDemo {
    public static void main(String[] args) {
        Sender sender = new Sender();
        ThreadedSend S1 = new ThreadedSend( " Hi " , sender);
        ThreadedSend S2 = new ThreadedSend( " Bye " , sender);

        S1.start();
        S2.start();

        try {
            S1.join();
            S2.join();
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
    }
}
