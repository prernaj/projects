package com.example.summary;

public class Thread1Sync extends Thread {
    PrintTestSync test;
    
    Thread1Sync(PrintTestSync p) { 
        test = p; 
    }

    public void run() {
        test.printThread(1);
    }

}
