package com.arkdex.springinaction.disruptorqueue.functionpointer;

public class RunMethod {
    // Method that takes a "method" as argument
    static void exampleMethod(Runnable toRun) {
        toRun.run();
    }

    // Method to pass
    static void sayHello() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        exampleMethod(RunMethod::sayHello);  // prints "Hello"
    }
}
