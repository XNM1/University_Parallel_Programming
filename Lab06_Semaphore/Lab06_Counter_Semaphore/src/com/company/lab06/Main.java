package com.company.lab06;

public class Main {

    public static void main( String argc[]) {
        System.out.println( "Main process started");
        CountingSemaphore semaphore = new CountingSemaphore();
        SendingThread sender1 = new SendingThread( semaphore);
        SendingThread sender2 = new SendingThread( semaphore);
        ReceivingThread receiver = new ReceivingThread( semaphore);

        receiver.start();
        sender1.start();
        sender2.start();
        System.out.println( "Main process ended");
    }
}
