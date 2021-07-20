package com.company.lab06;

public class Main {

    public static void main( String argc[]) {
        System.out.println( "Main process started");
        BoundedSemaphore semaphore = new BoundedSemaphore( 3);
        SendingThread sender1 = new SendingThread( "Sender 1", 1, semaphore);
        SendingThread sender2 = new SendingThread( "Sender 2", 10, semaphore);
        SendingThread sender3 = new SendingThread( "Sender 3", 100, semaphore);
        SendingThread sender4 = new SendingThread( "Sender 4", 1000, semaphore);
        SendingThread sender5 = new SendingThread( "Sender 5", 10000, semaphore);
        SendingThread sender6 = new SendingThread( "Sender 6", 100000, semaphore);
        ReceivingThread receiver = new ReceivingThread( "Receiver", 1, semaphore);

        receiver.start();
        sender1.start();
        sender2.start();
        sender3.start();
        sender4.start();
        sender5.start();
        sender6.start();
        System.out.println( "Main process ended");
    }
}
