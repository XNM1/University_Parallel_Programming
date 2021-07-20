package com.company.lab06;

class SendingThread extends Thread {
    BoundedSemaphore semaphore = null;
    String name;
    long procNum;

    SendingThread( String n, long p, BoundedSemaphore semaphore) {
        this.semaphore = semaphore;
        name = n;
        procNum = p;
        System.out.println( name + ": created");
    }

    public void run() {
        System.out.println( name + ": started");
        for (int i = 0; i < 4; ++i) {
            System.out.println( name + ": do(" + (i * procNum) + ")");
            try {
                this.semaphore.take( i * procNum);
            }
            catch (InterruptedException ie) {
            }
        }
        System.out.println( name + ": stoped");
    }
}
