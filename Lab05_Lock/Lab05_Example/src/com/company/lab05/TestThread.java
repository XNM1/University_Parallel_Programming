package com.company.lab05;

class TestThread extends Thread {
    String threadName;
    Counter c;
    int delay;

    TestThread(String name, int t, Counter cc) {
        threadName = name;
        c = cc;
        delay = t;
        System.out.println( threadName + " - Created");
    }

    public void run() {
        System.out.println( threadName + " - Start of Work");
        for (int i = 0; i < 10; ++i) {
            if (delay % 2 == 0) {
                System.out.println( threadName + " - increment " + c.inc());
            } else {
                System.out.println( threadName + " - decrement " + c.dec());
            }
            try {
                Thread.sleep( (int)((double)delay * 10.0 * Math.random()));
            }
            catch (InterruptedException ie) {
            }
        }
        System.out.println( threadName + " - End of Work");
    }
}
