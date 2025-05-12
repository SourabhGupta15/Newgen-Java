// Write a Java code to check if a number is even or odd

package practice;

import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        System.out.print("Enter any Number : ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        evenOdd(number);
        scanner.close();
    }

    public static void evenOdd(int num) {
        if(num % 2 == 0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }
}
