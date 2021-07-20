package com.company.lab06;

class Semaphore {
    private boolean signal = false;
    private int message = 0;

    public synchronized void take( int m) {
        this.signal = true;
        this.notify();
        message = m;
        System.out.println( "Semaphore take");
    }

    public synchronized int release() throws InterruptedException{
        while(!this.signal) {
            wait();
        }
        this.signal = false;
        System.out.println( "Semaphore release");
        return( message);
    }
}
