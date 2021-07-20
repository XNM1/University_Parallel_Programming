package com.company.lab03;


public class TestThread extends Thread {
    String threadName;
    CommonVariable parentClass;

    TestThread( String name, CommonVariable c) {
        threadName = name;
        parentClass = c;
        System.out.println( threadName + " - Created");
    }

    public void run() {
        System.out.println( threadName + " - Start of Work");
        while (parentClass.state != true) {
            System.out.println( threadName + " - " + parentClass.state);
            try {
                Thread.sleep( 10);
            }
            catch (InterruptedException ie) {
            }
        }
        System.out.println( threadName + " - " + parentClass.state);
        System.out.println( threadName + " - End of Work");
    }
}
