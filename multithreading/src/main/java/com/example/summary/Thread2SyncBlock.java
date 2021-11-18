package com.example.summary;

public class Thread2SyncBlock extends Thread {
    PrintTestSyncBlock test;
    
    Thread2SyncBlock(PrintTestSyncBlock p) { 
        test = p; 
    }

    public void run() {
        test.printThread(2);
    }

}
