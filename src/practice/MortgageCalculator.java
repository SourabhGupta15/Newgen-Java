package practice;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = mortgageCalculator(principal, monthlyInterest, numberOfPayments);
        
        System.out.print("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));

        scanner.close();
    }

    public static double mortgageCalculator(int principal, float monthlyInterest, int numberOfPayments) {
        
        double val = Math.pow((1 + monthlyInterest), (numberOfPayments));
        double mortgage = (principal * monthlyInterest * val) / (val - 1);
        return mortgage;
    }
}
