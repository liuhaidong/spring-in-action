package com.arkdex.springinaction.threadpool.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Company {
    public static void main(String[] args) throws InterruptedException {


        int count = 5;


        CountDownLatch latch = new CountDownLatch(count);

        ExecutorService threadPool =  Executors.newFixedThreadPool(count+3);

        System.out.println("employee will come");
        for(int i =0;i<count ;i++){
            Thread.sleep(10);
            threadPool.execute(new Employee(latch,i+1));
        }
        try {

            latch.await();

            System.out.println("every one is arrived");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            threadPool.shutdown();

        }
    }
}
