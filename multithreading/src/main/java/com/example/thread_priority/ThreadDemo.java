package com.example.thread_priority;

public class ThreadDemo extends Thread {

    public void run() {
        System.out.println("Inside run method");
    }

    public static void main(String[] args) {
        
        // Creating random threads with the help of above class
        ThreadDemo t1 = new ThreadDemo();
        ThreadDemo t2 = new ThreadDemo();
        ThreadDemo t3 = new ThreadDemo();

        System.out.println("t1 thread priority : " + t1.getPriority());
        System.out.println("t2 thread priority : " + t2.getPriority());
        System.out.println("t3 thread priority : " + t3.getPriority());

        t1.setPriority(2);
        t2.setPriority(5);
        t3.setPriority(8);

        System.out.println("t1 thread priority : " + t1.getPriority());
        System.out.println("t2 thread priority : " + t2.getPriority());
        System.out.println("t3 thread priority : " + t3.getPriority());

        System.out.println("Currently Executing Thread : " + Thread.currentThread().getName());

        System.out.println("Main thread priority : " + Thread.currentThread().getPriority());

        Thread.currentThread().setPriority(10);

        System.out.println("Main thread priority : " + Thread.currentThread().getPriority());

    }
}

/**
 * Output
 * t1 thread priority : 5
t2 thread priority : 5
t3 thread priority : 5
t1 thread priority : 2
t2 thread priority : 5
t3 thread priority : 8
Currently Executing Thread : main
Main thread priority : 5
Main thread priority : 10
 */

 /**
  * Output Explanation
Thread with the highest priority will get an execution chance prior to other threads. 
Suppose there are 3 threads t1, t2, and t3 with priorities 4, 6, and 1. 
So, thread t2 will execute first based on maximum priority 6 after that t1 will execute and then t3.

The default priority for the main thread is always 5, it can be changed later. 
The default priority for all other threads depends on the priority of the parent thread.
  */
