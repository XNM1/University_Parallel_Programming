package com.company.lab10;

import java.util.concurrent.Exchanger;

public class Main {

    public static void main(String[] args) {
        System . out . println ( " Main process started ") ;
        Exchanger< DataClass > exchanger = new Exchanger < DataClass >() ;
        Loop loop1 = new Loop ( 1 , " First ", exchanger ) ;
        Loop loop2 = new Loop ( 2 , " Second ", exchanger ) ;
        new Thread ( loop1 ) . start () ;
        new Thread ( loop2 ) . start () ;
        System . out . println ( " Main process ended ") ;
    }
}
