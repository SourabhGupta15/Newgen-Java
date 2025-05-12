// Write a Java code to check if a number is positive or negative.

package practice;

import java.util.Scanner;

public class PositiveNegative {
    public static void main(String[] args) {
        System.out.print("Enter any Number : ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        positiveNegative(number);
        scanner.close();
    }

    public static void positiveNegative(int num) {
        if(num < 0) {
            System.out.println("Negative Number");
        } else if(num == 0) {
            System.out.println("Neither Positive nor Negative Number");
        } else {
            System.out.println("Positive Number");
        }
    }
}
