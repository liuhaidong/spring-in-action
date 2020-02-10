package com.arkdex.springinaction.schedule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DigitCounts {
    private static int digitCounts(int k, int n) {
        // write your code here
        int i = 1;
        int j = 1;
        int j0 = 0;
        int p = 0;
        int count = 0;
        int n0 = n;
        int jSum = 0;
        int l = 0;
        while (n0 > 0 || i == 1) {
            j = n0 % 10;
            if (k == 0) {
                if (j != 0) {
                    count += l;
                    count += j * i / 10;
                    if (jSum > 0 && j0 == 0)
                        count += jSum + 1;
                }
                if (n < 10)
                    count = 1;
            } else {
                count += j * p;
                if (j >= k) {
                    if (p == 0)
                        count = 1;
                    else {
                        if (j > k)
                            count += i;
                        else
                            count += jSum + 1;
                    }
                }
            }
            if (p == 0) {
                p = 1;
            } else {
                p = p * 10 + i;
            }
            jSum += i * j;
            j0 = j;
            i = i * 10;
            n0 = (n0 - j) / 10;
            l++;
        }
        return count;

    }

    @Test
    public void testDigitCounts() {
        Assertions.assertTrue(digitCounts(0, 19) == 2);
       Assertions.assertTrue(digitCounts(0, 9) == 1);
        Assertions.assertTrue(digitCounts(0, 100) == 12);
        Assertions.assertTrue(digitCounts(0, 0) == 1);
        Assertions.assertTrue(digitCounts(1, 12) == 5);
        Assertions.assertTrue(digitCounts(1, 302) == 161);
        Assertions.assertTrue(digitCounts(2, 2000) == 601);
        Assertions.assertTrue(digitCounts(9, 9999) == 4000);
    }
}