package com.arkdex.springinaction.concurrency.utils;

import java.util.concurrent.ExecutorService;

public class ThreadUtils {
    public static void destory(ExecutorService executorService) {
        try {
            executorService.shutdown();
        } catch (Exception e) {
            executorService.shutdownNow();
        }
    }
}
