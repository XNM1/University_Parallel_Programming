package com.company.lab04;

public class Monitor implements Runnable {
    int procNum = 0;

    Monitor(int procNumber) {
        TestThread t[] = new TestThread[procNumber];
        for (int i = 0; i < procNumber; ++i) {
            t[i] = new TestThread( "Proc:" + i, this);
            t[i].start();
        }
    }

    public void run() {
        System.out.println( "Monitor - Started: " + getProcNum());
        try {
            while (getProcNum() != 0) {
                synchronized(this) {
                    System.out.println( "Monitor - Waiting: " + getProcNum());
                    wait();
                    System.out.println( "Monitor - Signal received: " + getProcNum());
                }
            }
        }
        catch (InterruptedException ee) {
            System.out.println( "Monitor - Interrupted Exception: " + ee.toString());
        }
        System.out.println( "Monitor - Ended: " + getProcNum());
    }

    public synchronized void procIncrement() {
        ++procNum;
    }

    public synchronized void procDecrement() {
        showMyFullName(3, "Artem Shevchenko");
        --procNum;
    }

    public synchronized int getProcNum() {
        return(procNum);
    }

    private synchronized void showMyFullName(int numProc, String fullName) {
        if (getProcNum() == numProc)
            System.out.println(fullName);
    }
}
