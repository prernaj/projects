package com.example.lifecycle_and_state;

public class Test implements Runnable {
    public static Thread thread1;
    public static Test obj;

    public void run() {
        thread myThread = new thread();
        Thread thread2 = new Thread(myThread);

        System.out.println("State of thread2 after creating it - "+ thread2.getState());
        thread2.start();
        System.out.println("State of thread2 after calling .start() method on it - " + thread2.getState());

        try {
            Thread.sleep(200);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State of thread2 after calling .sleep() method on it - " + thread2.getState());

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("State of thread2 when it has finished it's execution - " + thread2.getState());
    }

    public static void main(String[] args) {
        obj = new Test();
        thread1 = new Thread(obj);

        System.out.println("State of thread1 after creating it - " + thread1.getState()); 
        thread1.start();
        System.out.println("State of thread1 after calling .start() method on it - " + thread1.getState());
    }
}

/**
 * Output:
 * State of thread1 after creating it - NEW
State of thread1 after calling .start() method on it - RUNNABLE
State of thread2 after creating it - NEW
State of thread2 after calling .start() method on it - RUNNABLE
State of thread2 after calling .sleep() method on it - TIMED_WAITING
State of thread1 while it called join() method on thread2 -WAITING
State of thread2 when it has finished it's execution - TERMINATED
 */

 /**
  * Explanation
  When a new thread is created, the thread is in the NEW state. 
  When .start() method is called on a thread, the thread scheduler moves it to Runnable state. 
  Whenever join() method is called on a thread instance, the current thread executing that statement will wait for this thread to move to Terminated state. 
  So, before the final statement is printed on the console, the program calls join() on thread2 making the thread1 wait while thread2 completes its execution and is moved to Terminated state. 
  thread1 goes to Waiting state because it is waiting for thread2 to complete it’s execution as it has called join on thread2.
  */
