package com.arkdex.springinaction.threadpool.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName());
            }
        });

        for (int i = 0; i < N; i++)
            new Writer(barrier).start();
        System.out.println("back to main()...");
    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
            try {
                Thread.sleep(5000);
                System.out.println("Thread " + Thread.currentThread().getName() + " is done");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("all threads are done, other task continues ...");
        }
    }
}