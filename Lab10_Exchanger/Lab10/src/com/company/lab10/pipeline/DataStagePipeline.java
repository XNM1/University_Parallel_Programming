package com.company.lab10.pipeline;

class DataStagePipeline implements Pipelinable {
  int stage;
  double data;
  int stages;
  DataStagePipeline(double d, int stages) {
    this.stages = stages; stage = 0; data = d;
  }
  public int getStage() { return (stage); }
  public int getStages() { return (stages); }
  public double getData() { return (data); }
  public int nextStage() {
    if(stage % 2 == 0) {
      data = 1 / data;
    }
    else if (stage == stages) {
      return -1;
    }
    else {
      data = 1 + data;
    }
    return ++stage;
  }
}