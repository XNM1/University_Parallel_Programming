package com.company.lab04;

public class Main {

    public static void main( String argc[]) {
        System.out.println( "Main process started");
        Monitor m = new Monitor( 5);
        new Thread(m).start();
        System.out.println( "Main process ended");
    }
}
