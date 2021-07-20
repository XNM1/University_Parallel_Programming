package com.company.lab10.pipeline;

public class DataCount {
    private int count;
    public DataCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return this.count;
    }
    public void countDown() {
        count--;
    }
}
