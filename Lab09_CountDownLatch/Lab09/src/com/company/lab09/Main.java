package com.company.lab09;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        int rangeMin = Integer.parseInt(args[0]);
        int rangeMax = Integer.parseInt(args[1]);
        int arrSize  = Integer.parseInt(args[2]);
        int n = Integer.parseInt(args[3]);

        CountDownLatch stopLatch = new CountDownLatch(n);
        int resArr[] = new int[n];
        for (int i = 0; i < n; i++) {
            resArr[i] = -1;
        }

        int arr[] = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = (int)(Math.random() * (rangeMax - rangeMin) + rangeMin);
        }

        System.out.println("Мінімальне допустиме значення в послідовності чисел: " + rangeMin);
        System.out.println("Максимальне допустиме значення в послідовності чисел: " + rangeMax);
        System.out.println("Послідовність чисел: " +  Arrays.toString(arr));
        System.out.println("Кількість потоків: " + n);

        int step = Math.round((float)arrSize/n);
        for (int start = 0, j = 0; j < n; start+=step, ++j) {
            int end = (start+step >= arrSize || j == n - 1) ? arrSize : start+step;
            SearchLastNegative t = new SearchLastNegative( stopLatch, arr, resArr, start, end, j );
            t.start();
        }
        try {
            stopLatch.await();
        }
        catch ( InterruptedException e ) {
            System.err.println ( e.toString () );
        }
        int minI = -1;
        for (int i = resArr.length - 1; i >= 0; --i) {
            if (resArr[i] != -1) {
                minI = resArr[i];
                break;
            }
        }
        if (minI != -1) {
            System.out.println("Номер останнього негативного числа: " + (minI + 1));
        }
        else {
            System.out.println("Послыдовність не має негативних чисел");
        }
    }
}
