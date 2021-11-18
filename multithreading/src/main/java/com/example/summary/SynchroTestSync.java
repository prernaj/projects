package com.example.summary;

public class SynchroTestSync {
    public static void main(String[] args) {
        PrintTestSync p = new PrintTestSync();
        Thread1Sync t1 = new Thread1Sync(p);
        Thread2Sync t2 = new Thread2Sync(p);
        t1.start();
        t2.start();
    }
}
