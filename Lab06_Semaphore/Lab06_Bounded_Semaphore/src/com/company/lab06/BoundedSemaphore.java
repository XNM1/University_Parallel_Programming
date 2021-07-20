package com.company.lab06;

class BoundedSemaphore {
    private int signals = 0;
    private int bound = 0;
    private long message = 0;

    public BoundedSemaphore( int upperBound) {
        this.bound = upperBound;
    }

    public synchronized void take( long m) throws InterruptedException {
        while(this.signals == bound) {
            wait();
        }
        this.signals++;
        System.out.println( "BoundedSemaphore(take): " + this.signals);
        message = m;
        this.notify();
    }

    public synchronized long release() throws InterruptedException {
        while(this.signals == 0) {
            wait();
        }
        this.signals--;
        System.out.println( "BoundedSemaphore(release): " + this.signals);
        long m = message;
        message = 0;
        this.notify();
        return( m);
    }
}
