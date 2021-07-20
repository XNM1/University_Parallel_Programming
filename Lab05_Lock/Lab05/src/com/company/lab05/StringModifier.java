package com.company.lab05;

public class StringModifier {
    private Lock lock = new Lock();
    private StringBuilder str;

    public StringModifier(String s) {
        str = new StringBuilder(s);
    }

    private void modify(char c, int n) {
        try {
            for (int i = 0; i < str.length(); ++i) {
                lock.lock();
                if (str.charAt(i) == c) {
                    str.insert(i + 1, n);
                }
                lock.unlock();
            }
        }
        catch (InterruptedException ie) {
        }
    }

    public void workWithString(int n) {
        if (n == 0) {
            modify('A', n);
        }
        else if (n == 1) {
            modify('B', n);
        }
        System.out.println(str);
    }
}
