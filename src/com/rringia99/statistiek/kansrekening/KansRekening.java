package com.rringia99.statistiek.kansrekening;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

public class KansRekening {

    private BigDecimal x = BigDecimal.ZERO;
    private BigDecimal y = BigDecimal.ZERO;
    private BigDecimal xy = BigDecimal.ZERO;
    private BigDecimal x_bar = BigDecimal.ZERO;
    private BigDecimal y_bar = BigDecimal.ZERO;
    private BigDecimal x_square = BigDecimal.ZERO;
    private BigDecimal y_square = BigDecimal.ZERO;

    private ArrayList<BigDecimal> x_values;
    private ArrayList<BigDecimal> y_values;
    private BigDecimal length;

    public KansRekening(ArrayList<BigDecimal> x_values, ArrayList<BigDecimal> y_values) {
        this.x_values = x_values;
        this.y_values = y_values;
        this.length = new BigDecimal(x_values.size());


        for (int i = 0; i < this.length.intValue(); i++) {
            BigDecimal key = x_values.get(i);
            BigDecimal value = y_values.get(i);

            x = x.add(key);
            y = y.add(value);
            xy = xy.add(key.multiply(value));
            x_square = x_square.add(key.multiply(key));
            y_square = y_square.add(value.multiply(value));
        }

        x_bar = x.divide(this.length, 10, RoundingMode.CEILING);
        y_bar = y.divide(this.length, 10, RoundingMode.CEILING);
    }

    public String regressielijn() {
        return "y = " + this.a() + " + " + this.b() + " * x";
    }

    public BigDecimal regressielijnVoorspelling(BigDecimal value) {
        return this.a().add(this.b().multiply(value));
    }

    public BigDecimal correlatie() {
        BigDecimal r1 = xy.subtract(this.length.multiply(x_bar.multiply(y_bar)));
        BigDecimal r2x = (x_square.subtract(this.length.multiply(x_bar.multiply(x_bar)))).sqrt(new MathContext(100));
        BigDecimal r2y = (y_square.subtract(this.length.multiply(y_bar.multiply(y_bar)))).sqrt(new MathContext(100));

        return r1.divide(r2x.multiply(r2y), 6, RoundingMode.CEILING);
    }

    private BigDecimal a() {
        return this.y_bar.subtract(this.b().multiply(this.x_bar));
    }

    private BigDecimal b() {
        BigDecimal b1 = this.length.multiply(this.xy).subtract(this.x.multiply(this.y));
        BigDecimal b2 = this.length.multiply(this.x_square).subtract(this.x.multiply(this.x));

        return b1.divide(b2, 10, RoundingMode.CEILING);
    }
}
