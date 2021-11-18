package com.example.summary;

public class SynchroTestSyncBlock {
    public static void main(String[] args) {
        PrintTestSyncBlock p = new PrintTestSyncBlock();
        Thread1SyncBlock t1 = new Thread1SyncBlock(p);
        Thread2SyncBlock t2 = new Thread2SyncBlock(p);
        t1.start();
        t2.start();
    }
}
