package com.company.lab05;

public class CounterReentrant {
    private Lock lock = new Lock();
    private int count = 0;
    private int newCount;

    public int inc() {
        try {
            lock.lock();
            newCount = ++count;
            lock.unlock();
        }
        catch (InterruptedException ie) {
        }
        return newCount;
    }

    public int dec() {
        try {
            lock.lock();
            newCount = --count;
            lock.unlock();
        }
        catch (InterruptedException ie) {
        }
        return newCount;
    }
}
