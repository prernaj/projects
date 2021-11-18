package com.example.basic_thread_creation.creating_thread_by_extending_thread_class;

public class Multithread {
    public static void main(String[] args) {
        int n = 8;
        for (int i = 0; i < n; i++) {
            MultithreadingDemo demo = new MultithreadingDemo();
            demo.start();
        }
    }
}
