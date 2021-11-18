package com.example.summary;

public class Thread1 extends Thread {
    PrintTest test;
    
    Thread1(PrintTest p) { 
        test = p; 
    }

    public void run() {
        test.printThread(1);
    }

}
