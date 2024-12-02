package com.lecture;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {

        double a = 0.1;
        double b = 0.2;

        System.out.println(a + b); // 0.30000000000000004

        BigDecimal c = new BigDecimal("0.1");
        BigDecimal d = new BigDecimal("0.2");

        // Arithmetic operations with BigDecimal
        System.out.println(c.add(d)); // 0.3
        System.out.println(c.subtract(d)); // -0.1
        System.out.println(c.multiply(d)); // 0.02
        // Division with rounding
        System.out.println(c.divide(d, RoundingMode.HALF_UP)); // 0.5

        BigDecimal e = new BigDecimal("2.9");

        // Different rounding modes
        BigDecimal roundUp = e.setScale(0, RoundingMode.UP);
        BigDecimal roundHalfUp = e.setScale(0, RoundingMode.HALF_UP);
        BigDecimal roundDown = e.setScale(0, RoundingMode.DOWN);
        BigDecimal roundHalfDown = e.setScale(0, RoundingMode.HALF_DOWN);
        BigDecimal roundCeiling = e.setScale(0, RoundingMode.CEILING);
        BigDecimal roundFloor = e.setScale(0, RoundingMode.FLOOR);
        BigDecimal roundHalfEven = e.setScale(0, RoundingMode.HALF_EVEN);

        // Printing the results
        System.out.println("roundUp: " + roundUp); // Always rounds away from zero
        System.out.println("roundHalfUp: " + roundHalfUp); // Rounds up if >= 0.5
        System.out.println("roundDown: " + roundDown); // Always rounds towards zero
        System.out.println("roundHalfDown: " + roundHalfDown); // Rounds down if < 0.5
        System.out.println("roundCeiling: " + roundCeiling); // Rounds up for positive, down for negative
        System.out.println("roundFloor: " + roundFloor); // Rounds down for positive, up for negative
        System.out.println("roundHalfEven: " + roundHalfEven); // "Banker's rounding" - rounds to nearest even number
    }
}
