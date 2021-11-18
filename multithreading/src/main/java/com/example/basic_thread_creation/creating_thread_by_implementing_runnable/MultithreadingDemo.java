package com.example.basic_thread_creation.creating_thread_by_implementing_runnable;

public class MultithreadingDemo implements Runnable {
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        } catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }
}
