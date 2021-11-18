package com.example.thread_safety.synchronization;

public class A {
    synchronized void sum(int n) {
        Thread t = Thread.currentThread();
        for (int i = 1; i <= 5; i++) {
            System.out.println(t.getName() + " : " + (n + i));
        }
    }
}
