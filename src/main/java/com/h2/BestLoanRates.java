package com.h2;

import java.util.Map;
import java.util.Scanner;

public class BestLoanRates {
    public static final Map<Integer, Float> bestRates = Map.of(
            1,
            5.50f,
            2,
            3.45f,
            3,
            2.67f

    );
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("enter your name");
        String name = scanner.nextLine();
        System.out.println("Hello" + name);

        System.out.println("enter the loan term (in years");
        int loanTermInYears = scanner.nextInt();
        float bestRate = getRates(loanTermInYears);
        if(bestRate == 0.0f) {
            System.out.println("no available rates for term: " + loanTermInYears + "years");
        }else{
            System.out.println("Best available rate: " + getRates(loanTermInYears) + "%");
        }

    }

    public static float getRates(int loanTernInYears) {
        if(bestRates.containsKey(loanTernInYears)) {
            return bestRates.get(loanTernInYears);
        }
        return 0.0f;
    }
}