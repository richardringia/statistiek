package com.rringia99.statistiek.yules;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class YulesQ {
    public static BigDecimal calculate(BigDecimal a, BigDecimal b, BigDecimal c, BigDecimal d) {
        BigDecimal ad = a.multiply(d);
        BigDecimal bc = b.multiply(c);
        return ad.subtract(bc).divide(ad.add(bc), 10, RoundingMode.CEILING);
    }
}
