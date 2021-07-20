package com.company.lab06;

public class Main {

    public static void main( String argc[]) {
        System.out.println( "Main process started");
        Semaphore semaphore = new Semaphore();
        SendingThread sender = new SendingThread( semaphore);
        ReceivingThread receiver = new ReceivingThread( semaphore);

        receiver.start();
        sender.start();
        System.out.println( "Main process ended");
    }
}
