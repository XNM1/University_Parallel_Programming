package com.company.lab06;

class ReceivingThread extends Thread {
    CountingSemaphore semaphore = null;

    ReceivingThread( CountingSemaphore semaphore) {
        this.semaphore = semaphore;
        System.out.println( "ReceivingThread created");
    }

    public void run() {
        int sum = 0;
        System.out.println( "ReceivingThread started");
        while(true) {
            try {
                int m = this.semaphore.release();
                sum += m;
                System.out.println( "ReceivingThread do(" + m + "): " + sum);
            }
            catch (InterruptedException ie) {
            }
        }
    }
}
