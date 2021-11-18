package com.example.thread_synchronized;


public class ThreadedSend extends Thread {
    private String msg;
    Sender  sender;

    ThreadedSend(String m,  Sender obj) {
        msg = m;
        sender = obj;
    }

    public void run() {
        synchronized(sender) {
            // synchronizing the send object
            sender.send(msg);
        }
    }
}
