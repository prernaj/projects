package com.example.thread_priority;

public class ThreadSchedulerWorking extends Thread {
    public void run() {
        System.out.println("Inside run method");
    }

    public static void main(String[] args) {
        Thread.currentThread().setPriority(4);
        System.out.println("main thread priority : " + Thread.currentThread().getPriority());

        ThreadSchedulerWorking t = new ThreadSchedulerWorking();
        System.out.println("t thread priority : " + t.getPriority());
    }
}
