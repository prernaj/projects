package com.example.method_and_block_synchronization;

public class Train extends Thread {
    Line line;

    Train(Line line) {
        this.line = line;
    }

    @Override
    public void run() {
        line.getLine();
    }
}
