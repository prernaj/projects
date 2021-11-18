package com.example.main_thread;

public class ChildThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Child thread");
        }
    }
    
}
