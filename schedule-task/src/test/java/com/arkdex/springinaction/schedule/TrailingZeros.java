package com.arkdex.springinaction.schedule;

import org.junit.jupiter.api.Test;

public class TrailingZeros {

    private static Long doC(long n) {
        // write your code here, try to do it without arithmetic operators.
        long zeroCount = 0L;
        long num = 5L;
        while (num <= n) {
            zeroCount += n / num;
            num = num * 5;
        }
        return zeroCount;
    }

    @Test
    public void testZeros() {
        long count = doC(5555550000000L);
        System.out.println(count);
    }
}
