package com.company.lab03;

public class TestThread extends Thread {
    String threadName;
    CommonVariable parentClass;
    int position;

    TestThread( String name, CommonVariable c) {
        threadName = name;
        parentClass = c;
        parentClass.plusThread();
        position = parentClass.numberOfThreads;
        //System.out.println( threadName + " - Created");
    }

    public void run() {
        //System.out.println( threadName + " - Start of Work");
        while (true) {
            if (parentClass.state && (position % 2 == 0 || (parentClass.numberOfThreads <= (parentClass.maxThreads - parentClass.maxThreads / 2) && position % 2 != 0))) {
                parentClass.minusThread();
                break;
            }
            try {
                Thread.sleep( 10);
            }
            catch (InterruptedException ie) {
            }
        }
        System.out.println( threadName + " - End of Work");
    }
}
