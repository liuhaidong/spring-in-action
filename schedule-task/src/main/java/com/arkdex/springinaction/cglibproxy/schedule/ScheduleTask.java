package com.arkdex.springinaction.cglibproxy.schedule;

import org.springframework.scheduling.Trigger;

public class ScheduleTask {
    private Runnable task;
    private long period;
    private Trigger trigger;
    public ScheduleTask(Runnable task, long period){
        this.task = task;
        this.period = period;
    }

    public ScheduleTask(Runnable task, Trigger trigger){
        this.task = task;
        this.trigger = trigger;
    }

    public Runnable getTask() {
        return task;
    }

    public long getPeriod() {
        return period;
    }

    public Trigger getTrigger() {
        return trigger;
    }
}
