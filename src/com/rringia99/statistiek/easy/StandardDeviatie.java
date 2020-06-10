package com.rringia99.statistiek.easy;

import java.math.BigDecimal;
import java.math.MathContext;

public class StandardDeviatie {
    public static BigDecimal calculate(BigDecimal[] list) {
        BigDecimal variantie = new Variantie(list).calculate();
        return variantie.sqrt(new MathContext(10));
    }

    public static BigDecimal calculate(BigDecimal[] list, BigDecimal percentage) {
        BigDecimal variantie = new Variantie(list, percentage).calculate();
        return variantie.sqrt(new MathContext(10));
    }
}
