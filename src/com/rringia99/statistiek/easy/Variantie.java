package com.rringia99.statistiek.easy;

import com.rringia99.statistiek.BaseCalculate;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Variantie extends BaseCalculate {

    private BigDecimal[] list;
    private BigDecimal average;
    private BigDecimal[] variantieList;

    public Variantie(BigDecimal[] list) {
        this(list, new BigDecimal(1));
    }

    public Variantie(BigDecimal[] list, BigDecimal percentage) {
        int index = 0;
        for (BigDecimal x : list) {
            list[index] = x.multiply(percentage);
            index++;
        }
        this.list = list;
        this.average = new Average(list).calculate();
    }

    @Override
    public BigDecimal calculate() {
        this.variantieList = new BigDecimal[this.list.length];

        int index = 0;
        for (BigDecimal x : this.list) {
            System.out.println(x);
            this.variantieList[index] = x.subtract(this.average).stripTrailingZeros();
            this.variantieList[index] = this.variantieList[index].multiply(this.variantieList[index]);
            index++;
        }

        return Sum.calculate(this.variantieList).stripTrailingZeros().divide(new BigDecimal(this.list.length - 1), 10, RoundingMode.CEILING).stripTrailingZeros();
    }
}
