package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {
    private long loanAmount;
    private int ternInYears;
    private float annualRate;
    private double monthlyPayment;

    public MortgageCalculator(long loanAmount, int ternInYears, float annualRate) {
        this.loanAmount = loanAmount;
        this.ternInYears = ternInYears;
        this.annualRate = annualRate;
    }

    private int getNumber0Payments() {

        return ternInYears * 12;
    }

    private float getMonthlyInterestRate() {
        float interestRate = annualRate / 100;
        return interestRate / 12;
    }

    public void calculateMonthlyPayment() {
        long P = loanAmount;
        float r = getMonthlyInterestRate();
        int n = getNumber0Payments();

        double M = P * (((r * Math.pow((1 + r ), n)) - 1));
        this.monthlyPayment = M;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return "monthlyPayment: " + df.format(monthlyPayment);
    }

    public static void main(String[] args){
        long loanAmount = Long.parseLong(args[0]);
        int termInYears = Integer.parseInt(args[1]);
        float annualRate = Float.parseFloat(args[2]);

        MortgageCalculator calculator = new MortgageCalculator(loanAmount, termInYears, annualRate);
        calculator.calculateMonthlyPayment();
        System.out.println(calculator.toString());
    }

}