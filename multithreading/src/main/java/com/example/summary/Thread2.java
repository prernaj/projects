package com.example.summary;

public class Thread2 extends Thread {
    PrintTest test;
    
    Thread2(PrintTest p) { 
        test = p; 
    }

    public void run() {
        test.printThread(2);
    }

}
