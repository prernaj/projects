package com.example.thread_pool;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Task implements Runnable {

    private String name;
    
    public Task(String name) {
        this.name = name;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Date d = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                if (i == 0) {
                    System.out.println("Initialization Time for task name - "+ name +" = " +ft.format(d));
                } else {
                    System.out.println("Executing Time for task name - "+ name +" = " +ft.format(d)); 
                }
                Thread.sleep(1000);
            }
            System.out.println(name+" complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
