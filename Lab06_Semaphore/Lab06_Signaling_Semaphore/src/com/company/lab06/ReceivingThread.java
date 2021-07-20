package com.company.lab06;

class ReceivingThread extends Thread {
    Semaphore semaphore = null;

    ReceivingThread( Semaphore semaphore) {
        this.semaphore = semaphore;
        System.out.println( "ReceivingThread created");
    }

    public void run() {
        System.out.println( "ReceivingThread started");
        while(true) {
            try {
                int m = this.semaphore.release();
                System.out.println( "ReceivingThread do(" + m + ")");
            }
            catch (InterruptedException ie) {
            }
        }
    }
}
