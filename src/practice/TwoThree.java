// Write a Java code to check if a number is divisible by both 2 and 3.

package practice;

import java.util.Scanner;

public class TwoThree {
    public static void main(String[] args) {
        System.out.print("Enter any Number : ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        twoThree(number);
        scanner.close();
    }

    public static void twoThree(int num) {
        if(num % 2 == 0 && num % 3 == 0) {
            System.out.println(num + " is divisible by both 2 and 3.");
        } else if(num % 2 == 0) {
            System.out.println(num + " is divisible by only 2.");
        } else if(num % 3 == 0) {
            System.out.println(num + " is divisible by only 3.");
        }  else {
            System.out.println(num + " is not divisible by both 2 and 3.");
        }
    }
}
