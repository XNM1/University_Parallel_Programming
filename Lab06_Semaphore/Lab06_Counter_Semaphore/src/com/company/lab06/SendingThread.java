package com.company.lab06;

class SendingThread extends Thread {
    CountingSemaphore semaphore = null;

    SendingThread( CountingSemaphore semaphore) {
        this.semaphore = semaphore;
        System.out.println( "SendingThread created");
    }

    public void run() {
        System.out.println( "SendingThread started");
        for (int i = 0; i < 6; ++i) {
            System.out.println( "SendingThread do(" + i + ")");
            this.semaphore.take( i);
        }
        System.out.println( "SendingThread stoped");
    }
}
