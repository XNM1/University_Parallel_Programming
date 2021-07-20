package com.company.lab05;

class TestThread extends Thread {
    String threadName;
    StringModifier strMod;
    int pos;

    TestThread(String name, int p, StringModifier strM) {
        threadName = name;
        strMod = strM;
        pos = p;
        System.out.println( threadName + " - Created");
    }

    public void run() {
        System.out.println( threadName + " - Start of Work");
        strMod.workWithString(pos);
        try {
            Thread.sleep( (int)((double)pos * 10.0 * Math.random()));
        }
        catch (InterruptedException ie) {
        }
        System.out.println( threadName + " - End of Work");
    }
}
