package com.company.lab08;
import java.util.concurrent.*;

class LatchedThread extends Thread {
    private final CountDownLatch startLatch;
    private int procNumber;

    public LatchedThread( CountDownLatch s, int n) {
        startLatch = s;
        procNumber = n;
        System.out.println( "Thread(" + procNumber + "): created");
    }

    public void run() {
        System.out.println( "Thread(" + procNumber + "): started");
        try {
            startLatch.await();
            System.out.println( "Thread(" + procNumber + "): running");
        }
        catch(InterruptedException e) {
            System.err.println( e.toString());
        }
        System.out.println( "Thread(" + procNumber + "): stoped");
    }
}
