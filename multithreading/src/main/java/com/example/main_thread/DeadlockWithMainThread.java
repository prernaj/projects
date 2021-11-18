package com.example.main_thread;

public class DeadlockWithMainThread {
    public static void main(String[] args) {
        try {
            System.out.println("Entering into deadlock");
            Thread.currentThread().join();
            System.out.println("This statement will never execute");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * Output:
 * Entering into deadlock
 * 
 * Output explanation: 
The statement “Thread.currentThread().join()”, will tell Main thread to wait for this thread(i.e. wait for itself) to die.
Thus Main thread wait for itself to die, which is nothing but a deadlock.
 */
