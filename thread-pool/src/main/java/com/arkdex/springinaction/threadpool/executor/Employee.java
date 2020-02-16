package com.arkdex.springinaction.threadpool.executor;

import java.util.concurrent.CountDownLatch;

class Employee implements Runnable{

    private CountDownLatch latch;
    private int employeeIndex;

    public Employee(CountDownLatch latch,int employeeIndex){
        this.latch = latch;
        this.employeeIndex = employeeIndex;
    }

    @Override
    public void run() {
        try {
            System.out.println("Employee："+employeeIndex+" is coming ...");
            Thread.sleep(10);
            System.out.println("Employee："+employeeIndex+" is arrived");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            latch.countDown();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Employee："+employeeIndex+" is waiting ....");
        }
    }
}
