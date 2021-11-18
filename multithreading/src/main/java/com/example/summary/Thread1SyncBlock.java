package com.example.summary;

public class Thread1SyncBlock extends Thread {
    PrintTestSyncBlock test;
    
    Thread1SyncBlock(PrintTestSyncBlock p) { 
        test = p; 
    }

    public void run() {
        test.printThread(1);
    }

}
