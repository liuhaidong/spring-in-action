package com.arkdex.springinaction.threadpool;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ChartDataProducer implements Runnable {
    boolean isSendFinish;

    private final BlockingQueue<ChartData> queue;

    public ChartDataProducer(BlockingQueue<ChartData> queue, Boolean isSendFinish) {
        this.queue = queue;
        this.isSendFinish = isSendFinish;
    }

    @Override
    public void run() {
        try {
           // while (true)
                generateChartData();
        } catch (InterruptedException e) {
            Thread.currentThread()
                    .interrupt();
        }
    }

    private void generateChartData() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(500);
            ChartData chartData = new ChartData(Integer.valueOf(i), ThreadLocalRandom.current().nextDouble(100d), new Date(), threadName);
            queue.put(chartData);
            System.out.println(threadName + " produced  " + i +" at price "+ chartData.getPrice());
        }
        if (isSendFinish) {
            ChartData chartData = new ChartData(Integer.valueOf(-1), ThreadLocalRandom.current().nextDouble(100d), new Date(), threadName);
            queue.put(chartData);
        }
    }
}
