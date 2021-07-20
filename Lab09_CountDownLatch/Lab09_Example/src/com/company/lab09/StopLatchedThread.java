package com.company.lab09;
import java.util.concurrent.*;

class StopLatchedThread extends Thread {
    private final CountDownLatch stopLatch;
    private int procNumber;
    public StopLatchedThread( CountDownLatch s , int n ) {
        stopLatch = s;
        procNumber = n;
        System.out.println( " Thread (" + procNumber + "): created ");
    }
    public void run () {
        System.out.println( " Thread (" + procNumber + "): started ");
        System.out.println( " Thread (" + procNumber + "): running ") ;
        System.out.println( " Thread (" + procNumber + "): stoped ") ;
        stopLatch.countDown() ;
    }
}