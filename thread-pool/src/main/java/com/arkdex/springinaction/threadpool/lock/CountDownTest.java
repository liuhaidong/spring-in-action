package com.arkdex.springinaction.threadpool.lock;

import java.util.concurrent.CountDownLatch;

public class CountDownTest {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(){
            public void run() {
                try {
                    System.out.println("Thread "+Thread.currentThread().getName()+" is running");
                    Thread.sleep(3000);
                    System.out.println("Thread "+Thread.currentThread().getName()+" is done");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        new Thread(){
            public void run() {
                try {
                    System.out.println("Thread "+Thread.currentThread().getName()+" is running");
                    Thread.sleep(3000);
                    System.out.println("Thread "+Thread.currentThread().getName()+" is done");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        try {
            System.out.println("waiting 2 threads...");
            latch.await();
            System.out.println("All 2 threads are done");
            System.out.println("back to Main");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
