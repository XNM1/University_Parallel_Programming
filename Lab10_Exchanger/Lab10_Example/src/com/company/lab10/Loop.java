package com.company.lab10;

import java.util.concurrent.Exchanger;

class Loop implements Runnable {
    int counter;
    String name;
    Exchanger<DataClass> exchanger;

    Loop(int startValue, String id, Exchanger<DataClass> ex) {
        counter = startValue;
        name = id;
        exchanger = ex;
        System.out.println(name + ": created ");
    }

    public void run() {
        System.out.println(name + ": started ");
        DataClass data = new DataClass(counter, name);
        for (int i = 0; i < 3; ++i) {
            try {
                DataClass newData = exchanger.exchange(data);
                counter += newData.getValue();
                System.out.println(name + ": from " +
                        newData.getMassage() + ": data : " +
                        newData.getValue() + ": state = " + counter);
            } catch (InterruptedException e) {
                System.err.println(e.toString());
            }
        }
        System.out.println(name + ": ended ");
    }
}
