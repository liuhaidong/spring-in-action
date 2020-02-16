package com.arkdex.springinaction.threadpool;

import java.util.concurrent.*;


public class ThreadPoolApplication {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        BlockingQueue<ChartData> queue = new LinkedBlockingQueue<>(100);
        int producerCount = 2;
        CountDownLatch countDownLatch = new CountDownLatch(producerCount+1);
        for (int i = 0; i < producerCount; i++) {
            //new Thread(new ChartDataProducer(queue, countDownLatch));
            executorService.submit(new ChartDataProducer(queue, countDownLatch));
        }
        //new Thread(new ChartDataConsumer(queue, countDownLatch, 2));
        executorService.submit(new ChartDataConsumer(queue, countDownLatch,2));


        try {
            countDownLatch.await();
            executorService.shutdown();
            System.out.println("All threads are done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {


        }
    }

}
