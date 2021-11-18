package com.example.thread_safety.synchronization;

public class B extends Thread {
    A a = new A();

    public void run() {
        a.sum(10);
    }
}
