package com.example.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FixedThreadPool
 * 1. Create a task(Runnable Object) to execute
 * 2. Create Executor Pool using Executors
 * 3. Pass tasks to Executor Pool
 * 4. Shutdown the Executor Pool
 */
public class FixedThreadPool {

    // Maximum number of threads in thread pool
    static final int MAX_T = 3;  


    public static void main(String[] args) {
        Runnable r1 = new Task("task 1");
        Runnable r2 = new Task("task 2");
        Runnable r3 = new Task("task 3");
        Runnable r4 = new Task("task 4");
        Runnable r5 = new Task("task 5");

        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        
        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5); 

        pool.shutdown(); 


    }
}

/**
 * Output
 * Initialization Time for task name - task 1 = 02:05:52
Initialization Time for task name - task 3 = 02:05:52
Initialization Time for task name - task 2 = 02:05:52
Executing Time for task name - task 2 = 02:05:53
Executing Time for task name - task 3 = 02:05:53
Executing Time for task name - task 1 = 02:05:53
Executing Time for task name - task 2 = 02:05:54
Executing Time for task name - task 1 = 02:05:54
Executing Time for task name - task 3 = 02:05:54
Executing Time for task name - task 3 = 02:05:55
Executing Time for task name - task 2 = 02:05:55
Executing Time for task name - task 1 = 02:05:55
Executing Time for task name - task 3 = 02:05:56
Executing Time for task name - task 1 = 02:05:56
Executing Time for task name - task 2 = 02:05:56
task 1 complete
task 3 complete
task 2 complete
Initialization Time for task name - task 4 = 02:05:57
Initialization Time for task name - task 5 = 02:05:57
Executing Time for task name - task 4 = 02:05:58
Executing Time for task name - task 5 = 02:05:58
Executing Time for task name - task 5 = 02:05:59
Executing Time for task name - task 4 = 02:05:59
Executing Time for task name - task 4 = 02:06:00
Executing Time for task name - task 5 = 02:06:00
Executing Time for task name - task 4 = 02:06:01
Executing Time for task name - task 5 = 02:06:01
task 5 complete
task 4 complete
 */

 /**
  * As seen in the execution of the program, 
  the task 4 or task 5 are executed only when a thread in the pool becomes idle. Until then, the extra tasks are placed in a queue.
  */
