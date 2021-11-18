package com.example.basic_thread_creation.creating_thread_by_extending_thread_class;

public class MultithreadingDemo extends Thread {
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        } catch (Exception e) {
            System.out.println("exception is caught");
        }
    }
}
