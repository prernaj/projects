package com.example.summary;

public class SynchroTestStatic {
    public static void main(String[] args) {
        Thread1Static t1 = new Thread1Static();
        Thread2Static t2 = new Thread2Static();
        t1.start();
        t2.start();
    }
}
