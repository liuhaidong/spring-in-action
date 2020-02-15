package com.arkdex.springinaction.threadpool;

import java.util.concurrent.BlockingQueue;

public class ChartDataConsumer implements Runnable {

    private final BlockingQueue<ChartData> queue;
    private final int producerCount;

    public ChartDataConsumer(BlockingQueue<ChartData> queue, int producerCount) {
        this.queue = queue;
        this.producerCount = producerCount;
    }


    @Override
    public void run() {
        int exitProducerCount = 0;
        try {
            while (true) {
                ChartData chartData = queue.take();
                if (chartData.getId().equals(-1)) {
                    System.out.println(Thread.currentThread().getName() + " finished. ");
                    exitProducerCount++;
                    if (producerCount == exitProducerCount) {
                           return;
                    }
                } else {
                    String result = chartData.getPrice().toString();
                    System.out.println(Thread.currentThread().getName() + " consumed: " + result + " from " + chartData.getFrom());
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
