package com.rringia99.statistiek.easy;

import com.rringia99.statistiek.BaseCalculate;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Average extends BaseCalculate {
    private BigDecimal[] list;

    public Average(BigDecimal[] list) {
        this.list = list;
    }


    @Override
    public BigDecimal calculate() {
        return Sum.calculate(this.list).divide(new BigDecimal(this.list.length), 10, RoundingMode.CEILING);
    }
}
