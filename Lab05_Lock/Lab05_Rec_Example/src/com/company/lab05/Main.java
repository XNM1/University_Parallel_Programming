package com.company.lab05;

public class Main {

    public static void main( String argc[]) {
        System.out.println( "Main process started");
        CounterReentrant cnt = new CounterReentrant();
        TestThread t[] = new TestThread[10];
        for (int i = 0; i < 10; ++i) {
            t[i] = new TestThread( "Proc:" + i, i, cnt);
            t[i].start();
        }
        System.out.println( "Main process ended");
    }
}
