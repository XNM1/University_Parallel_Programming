package com.company.lab04;

class TestThread extends Thread {
    String threadName;
    Monitor m;

    TestThread(String name, Monitor mm) {
        threadName = name;
        m = mm;
        System.out.println(threadName + " - Created");
    }

    public void run() {
        m.procIncrement();
        System.out.println( threadName + " - Start of Work");
        try {
            Thread.sleep( 100);
        }
        catch (InterruptedException ie) {
        }
        m.procDecrement();
        synchronized(m) {
            m.notify();
            System.out.println( threadName + " - Signal sended");
        }
        System.out.println( threadName + " - End of Work");
    }
}