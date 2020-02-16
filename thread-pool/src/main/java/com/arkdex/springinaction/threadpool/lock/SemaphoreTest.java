package com.arkdex.springinaction.threadpool.lock;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        int N = 8;
        Semaphore semaphore = new Semaphore(5); //tools count
        for(int i=0;i<N;i++)
            new Worker(i,semaphore).start();
    }

    static class Worker extends Thread{
        private int id;
        private Semaphore semaphore;
        public Worker(int id,Semaphore semaphore){
            this.id = id;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("worker "+this.id+" occupied 1 tool ...");
                Thread.sleep(2000);
                System.out.println("worker "+this.id+" released 1 tool");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
