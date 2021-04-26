package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
    private float [] credits;
    private float [] debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }

    private float sumOfCredits() {
        float sum = 0.0f;
        for(float credit: credits) {
            sum += credit;

        }
        return sum;
    }

    private float sumOfDebits() {
        float sum = 0.0f;
        for(float debit: debits) {
            sum += debit;
        }
        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date) {
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalTotalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalTotalDaysInMonth - date.getDayOfMonth();
        return remainingDays;
    }

    public float calculate () {
        return sumOfCredits() - sumOfDebits();
    }

    public static void main (String[] args) {
        final String[] credtisAsString = args[0].split(",");
        final String[] debitsAsString = args[1].split(",");

        final float[] credits = new float[credtisAsString.length];
        final float[] debits = new float[debitsAsString.length];

        for (int i = 0; i < credits.length; i++) {
            credits[i] = Float.parseFloat(credtisAsString[i]);
        }

        for (int i = 0; i < debits.length; i++) {
            debits[i] = Float.parseFloat(debitsAsString[i]);
        }

        final SavingsCalculator calculator = new SavingsCalculator(credits, debits);
        float netSavings = calculator.calculate();
        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }
}