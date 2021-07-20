package com.company.lab09;
import java.util.concurrent.*;

public class SearchLastNegative extends Thread {
    private final CountDownLatch stopLatch;
    private int start;
    private int end;
    private int resIndex;
    private int[] arr;
    private int[] rarr;
    public SearchLastNegative( CountDownLatch sl, int[] c, int[] r, int s, int e, int ri) {
        stopLatch = sl;
        arr = c;
        rarr = r;
        resIndex = ri;
        start = s;
        end = e;
    }
    public void run () {
        int minI = -1;
        for (int i = end - 1; i >= start; --i) {
            if (arr[i] < 0) {
                minI = i;
                break;
            }
        }
        rarr[resIndex] = minI;
        stopLatch.countDown() ;
    }
}