package com.arkdex.springinaction.disruptorqueue.schedule;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.ScheduledMethodRunnable;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

@Component
public
class CustomTaskScheduler extends ThreadPoolTaskScheduler implements TaskFuture {
    private final Map<String, ScheduledFuture<?>> scheduledFutures =
            new HashMap<>();

    private final Map<String, ScheduleTask> scheduledTask =
            new HashMap<>();

    public String getFutureNames() {
        String s = "";
        if (scheduledFutures.size() > 0) {
            s = scheduledFutures.keySet().toString();
        }
        return s;
    }

    public void stopTask(int i) {
        String taskName = scheduledFutures.keySet().toArray()[i].toString();
        scheduledFutures.get(taskName).cancel(true);
    }

    public void startTask(String taskName) {
        ScheduleTask scheduleTask = scheduledTask.get(taskName);
        if (scheduleTask != null) {
            if (scheduleTask.getTrigger() == null)
                scheduleAtFixedRate(scheduleTask.getTask(), scheduleTask.getPeriod());
            else
                schedule(scheduleTask.getTask(), scheduleTask.getTrigger());
        }

    }

    @Override
    public ScheduledFuture<?> schedule(Runnable task, Trigger trigger) {
        ScheduledFuture<?> future = super.schedule(task, trigger);
        ScheduledMethodRunnable runnable = (ScheduledMethodRunnable) task;
        String taskName = ((ScheduledMethodRunnable) task).getMethod().getDeclaringClass().getName();
        scheduledFutures.put(taskName, future);
        scheduledTask.put(taskName, new ScheduleTask(task, trigger));

        return future;
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, long period) {
        ScheduledFuture<?> future = super.scheduleAtFixedRate(task, period);

        ScheduledMethodRunnable runnable = (ScheduledMethodRunnable) task;
        String taskName = ((ScheduledMethodRunnable) task).getMethod().getDeclaringClass().getName();
        scheduledFutures.put(taskName, future);
        scheduledTask.put(taskName, new ScheduleTask(task, period));

        return future;
    }

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, Date startTime, long period) {
        ScheduledFuture<?> future = super.scheduleAtFixedRate(task, startTime, period);

        ScheduledMethodRunnable runnable = (ScheduledMethodRunnable) task;
        String taskName = ((ScheduledMethodRunnable) task).getMethod().getClass().getName();
        scheduledFutures.put(taskName, future);

        return future;
    }
}
