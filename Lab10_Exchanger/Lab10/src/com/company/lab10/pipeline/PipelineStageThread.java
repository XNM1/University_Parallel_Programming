package com.company.lab10.pipeline;

import java.util.concurrent.Exchanger;

class PipelineStageThread implements Runnable {
  DataStagePipeline data;
  String name;
  Exchanger<DataStagePipeline> exchangerSender;
  Exchanger<DataStagePipeline> exchangerReceiver;
  DataCount pipelineDataCount;

  PipelineStageThread(DataStagePipeline startData, String name, Exchanger<DataStagePipeline> exchangerSender, Exchanger<DataStagePipeline> exchangerReceiver, DataCount pipelineDataCount) {
    this.name = name;
    this.exchangerSender = exchangerSender;
    this.exchangerReceiver = exchangerReceiver;
    data = startData;
    this.pipelineDataCount = pipelineDataCount;
    System.out.println(name + ": created");
  }

  public void setData(DataStagePipeline data) {
    try {
      if (exchangerReceiver == null) {
        while(this.data != null) { Thread.sleep(100);}
        this.data = data;
      }
    }
    catch (Exception e) {}
  }

  public void run () {
    System.out.println(name + ": started");
    try {
      while (pipelineDataCount.getCount() > 0) {
        receiveData();
        if (data != null && data.getStage() < data.getStages()) {
          data.nextStage();
        }
        sendData();
        showResult();
        Thread.sleep(2);
      }
    }
    catch (InterruptedException e) {
    System.err.println(e.toString());
    }
    System.out.println(name + ": ended");
  }

  private void receiveData() throws InterruptedException {
    while(data == null && exchangerReceiver != null) {
      this.data = exchangerReceiver.exchange(null);
      System.out.println("Receive: " + name + "; message: " + data.getData() + "; stage: " + data.getStage());
    }
  }

  private void sendData() throws InterruptedException {
    if (data != null && exchangerSender != null) {
      exchangerSender.exchange(data);
      System.out.println("Sender: " + name +"; message: " + data.getData() + "; stage: " + data.getStage());
      data = null;
      if (exchangerReceiver == null) pipelineDataCount.countDown();
    }
  }

  private void showResult() {
    if (exchangerSender == null && data != null) {
      System.out.println("Final: " + name +"; final result: " + data.getData() + "; stage: " + data.getStage());
      data = null;
    }
  }

}