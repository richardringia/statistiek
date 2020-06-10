package com.rringia99.statistiek.easy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ZValue {
    /**
     * Hoeveel standaard deviaties ligt het getal af van het gemiddelde.
     *
     * @param x huidige observatie
     * @param average het gemiddelde
     * @param standardDeviatie
     */
    public static BigDecimal calculate(BigDecimal x, BigDecimal average, BigDecimal standardDeviatie) {
        return x.subtract(average).divide(standardDeviatie, 10, RoundingMode.CEILING);
    }
}
