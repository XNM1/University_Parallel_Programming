package com.company.lab06;

class CountingSemaphore {
    private int signals = 0;
    private int message = 0;

    public synchronized void take( int m) {
        this.signals++;
        message = m;
        this.notify();
        System.out.println( "CountingSemaphore(take): " + this.signals);
    }

    public synchronized int release() throws InterruptedException {
        while(this.signals == 0) {
            wait();
        }
        this.signals--;
        System.out.println( "CountingSemaphore(release): " + this.signals);
        return( message);
    }
}
