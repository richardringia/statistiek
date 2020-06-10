package com.rringia99.statistiek.yules;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Percentage {
    public static BigDecimal calculate(BigDecimal total, BigDecimal sample) {
        return sample.divide(total, 10, RoundingMode.CEILING);
    }

    public static BigDecimal calculatePercentage(BigDecimal total, BigDecimal sample) {
        return Percentage.calculate(total, sample).multiply(new BigDecimal(100));
    }
}
