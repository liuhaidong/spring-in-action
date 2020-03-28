package com.arkdex.springinaction.disruptorqueue.schedule;

public interface TaskFuture {
    String getFutureNames();
    void stopTask(int i);
}
