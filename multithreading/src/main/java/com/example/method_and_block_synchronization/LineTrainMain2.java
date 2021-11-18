package com.example.method_and_block_synchronization;

public class LineTrainMain2 {
    public static void main(String[] args) {
        Line2 obj = new Line2();
        Train2 train1 = new Train2(obj);
        Train2 train2 = new Train2(obj);

        train1.start();
        train2.start();
    }
}
