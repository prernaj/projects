package com.example.method_and_block_synchronization;

public class Train2 extends Thread {
    Line2 line;

    Train2(Line2 line) {
        this.line = line;
    }

    @Override
    public void run() {
        line.getLine();
    }
}
