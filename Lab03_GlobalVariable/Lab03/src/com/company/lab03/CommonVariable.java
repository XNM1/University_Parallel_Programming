package com.company.lab03;

public class CommonVariable {
    boolean state = false;
    int numberOfThreads = 0;
    int maxThreads = 0;
    private boolean block = false;

    CommonVariable() {
        state = false;
        numberOfThreads = 0;
    }

    public static void main( String argc[]) {
        //System.out.println( "Main process started");
        CommonVariable cv = new CommonVariable();
        TestThread t1 = new TestThread( "First", cv);
        TestThread t2 = new TestThread( "Second", cv);
        TestThread t3 = new TestThread( "Third", cv);
        TestThread t4 = new TestThread( "Fourth", cv);
        TestThread t5 = new TestThread( "Fifth", cv);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            Thread.sleep( 60);
        }
        catch (InterruptedException ie) {
        }
        cv.state = true;
        System.out.println( "Main process ended");
    }

    public void plusThread() {
        if (!this.block) {
            this.block = true;
            this.maxThreads = ++this.numberOfThreads;
        }
        this.block = false;
    }

    public void minusThread() {
        if (!this.block) {
            this.block = true;
            --this.numberOfThreads;
        }
        this.block = false;
    }
}
