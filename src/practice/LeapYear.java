// Write a Java code to find if a year is a leap year or not.

package practice;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        System.out.print("Enter a Year : ");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        leapYear(year);
        scanner.close();
    }

    public static void leapYear(int num) {
        if(num % 400 == 0 || num % 100 != 0 && num % 4 == 0) {
            System.out.println("It is a Leap Year.");
        } else {
            System.out.println("Not a Leap Year.");
        }
    }
}
