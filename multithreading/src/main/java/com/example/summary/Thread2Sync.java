package com.example.summary;

public class Thread2Sync extends Thread {
    PrintTestSync test;
    
    Thread2Sync(PrintTestSync p) { 
        test = p; 
    }

    public void run() {
        test.printThread(2);
    }

}
