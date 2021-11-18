package com.example.thread_safety.atomic_variable;

import java.util.concurrent.atomic.AtomicInteger;


public class Counter {
    AtomicInteger count = new AtomicInteger();

    public void increment() {
        count.incrementAndGet();
    }

}
