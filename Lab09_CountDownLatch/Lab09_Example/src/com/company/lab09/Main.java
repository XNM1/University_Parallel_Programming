package com.company.lab09;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        CountDownLatch stopLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; ++ i) {
            StopLatchedThread t = new StopLatchedThread( stopLatch , i + 1 );
            t.start();
        }
        try {
            stopLatch.await();
        }
        catch ( InterruptedException e ) {
            System.err.println ( e.toString () );
        }
        System.out.println ( " Main process stoped ");
    }
}
