package com.company.lab10.pipeline;

import java.util.concurrent.Exchanger;

// pipeline for y = 1+1/(1+1/(1+1/(1+1/x)))

class Main {
  public static void main(String args[]) {
    int stages = 8;
    int[] data = {14, 12, 7, 8, 31};
    int numExch = stages - 1;
    DataCount countData = new DataCount(data.length);

    Exchanger<DataStagePipeline>[] exchangers = new Exchanger[numExch];
    for(int i = 0; i < numExch; ++i) {
      exchangers[i] = new Exchanger<DataStagePipeline>();
    }

    PipelineStageThread[] pipelineStageThreads = new PipelineStageThread[stages];
    pipelineStageThreads[0] = new PipelineStageThread(null, "Thread 0", exchangers[0], null, countData);
    new Thread(pipelineStageThreads[0]).start();
    for(int i = 1; i < stages - 1; ++i) {
      pipelineStageThreads[i] = new PipelineStageThread(null, "Thread " + i, exchangers[i], exchangers[i - 1], countData);
      new Thread(pipelineStageThreads[i]).start();
    }
    pipelineStageThreads[stages - 1] = new PipelineStageThread(null, "Thread " + (stages - 1), null, exchangers[numExch - 1], countData);
    new Thread(pipelineStageThreads[stages - 1]).start();

    for (int i = 0; i < data.length; i++) {
      pipelineStageThreads[0].setData(new DataStagePipeline(data[i], stages));
    }
  }
}