package com.rringia99.statistiek;

import com.rringia99.statistiek.easy.*;
import com.rringia99.statistiek.kansrekening.KansRekening;
import com.rringia99.statistiek.yules.Percentage;
import com.rringia99.statistiek.yules.YulesQ;

import java.math.BigDecimal;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        BigDecimal[] list = new BigDecimal[]{new BigDecimal("8.2"), new BigDecimal("8.9"), new BigDecimal("7.2"), new BigDecimal("7.8"), new BigDecimal("6.3")};
//        System.out.println(StandardDeviatie.calculate(list));
//        System.out.println(StandardDeviatie.calculate(list, new BigDecimal("0.9")));
//        System.out.println(Percentage.calculate(new BigDecimal(45), new BigDecimal(25)));
//        System.out.println(Percentage.calculatePercentage(new BigDecimal(45), new BigDecimal(25)));

//        System.out.println(YulesQ.calculate(new BigDecimal(12), new BigDecimal(3), new BigDecimal(8), new BigDecimal(22)));

//        System.out.println(ZValue.calculate(new BigDecimal(8), new BigDecimal(10), new BigDecimal(2)));
//        System.out.println(ZValue.calculate(new BigDecimal(12), new BigDecimal(10), new BigDecimal(2)));
//        System.out.println(ZValue.calculate(new BigDecimal(9), new BigDecimal(10), new BigDecimal(2)));
//        System.out.println(ZValue.calculate(new BigDecimal(11), new BigDecimal(10), new BigDecimal(2)));


        KansRekening kansRekening = new KansRekening(
                new ArrayList<>(Arrays.asList(new BigDecimal(77), new BigDecimal(82), new BigDecimal(95))),
                new ArrayList<>(Arrays.asList(new BigDecimal(8200), new BigDecimal(8900), new BigDecimal(7200)))
        );

        System.out.println(kansRekening.regressielijn());
        System.out.println(kansRekening.regressielijnVoorspelling(new BigDecimal(100)));


    }
}
