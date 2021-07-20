package com.company.lab06;

class ReceivingThread extends Thread {
    BoundedSemaphore semaphore = null;
    String name;
    int procNum;
    long sum = 0;

    ReceivingThread( String n, int p, BoundedSemaphore semaphore) {
        this.semaphore = semaphore;
        name = n;
        procNum = p;
        System.out.println( name + ": created");
    }

    public void run() {
        System.out.println( name + ": started");
        while(true) {
            try {
                long m = this.semaphore.release();
                sum += m;
                System.out.println( name + ": do(" + m + "), " + sum);
            }
            catch (InterruptedException ie) {
            }
        }
    }
}
