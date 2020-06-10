package com.rringia99.statistiek.easy;

import java.math.BigDecimal;

public class Sum {
    public static BigDecimal calculate(BigDecimal[] list) {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal value : list) {
            sum = sum.add(value);
        }
        return sum;
    }
}
