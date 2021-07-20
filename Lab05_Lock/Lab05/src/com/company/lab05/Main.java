package com.company.lab05;

public class Main {

    public static void main(String[] args) {
        System.out.println( "Main process started");
        StringModifier stringModifier = new StringModifier("ABCDEFABCDEF");
        TestThread t[] = new TestThread[2];
        for (int i = 0; i < 2; ++i) {
            t[i] = new TestThread( "Proc:" + i, i, stringModifier);
            t[i].start();
        }
        System.out.println( "Main process ended");
    }
}
