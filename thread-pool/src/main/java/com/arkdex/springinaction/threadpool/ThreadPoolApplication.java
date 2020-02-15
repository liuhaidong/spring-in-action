package com.arkdex.springinaction.threadpool;

import java.util.concurrent.*;


public class ThreadPoolApplication {

    public static void main(String[] args) {
        BlockingQueue<ChartData> queue = new LinkedBlockingQueue<>(100);
        int producerCount = 2;
        for (int i = 0; i < producerCount; i++) {
            new Thread(new ChartDataProducer(queue, true)).start();
        }

        new Thread(new ChartDataConsumer(queue, producerCount)).start();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> "Hello World");
// some operations
        try {
            String result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
