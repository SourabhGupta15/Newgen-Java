package practice;

import java.util.Scanner;

public class ForLoopExamples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        int num = scanner.nextInt();
        printNumbers(num);
        printSumOfNumbers(num);
        printEvenNumbers(num);
        printOddNumbers(num);
        printFactorial(num);
        scanner.close();
    }

    public static void printNumbers(int num) {
        for(int i = 1; i <= num; i++) {
            System.out.println(i);
        }
    }

    public static void printSumOfNumbers(int num) {
        int sum = 0;
        for(int i = 1; i <= num; i++) {
            sum = sum + i;
        }
        System.out.println("Sum = " + sum);
    }

    public static void printEvenNumbers(int num) {
        System.out.println("Even Numbers : ");
        for(int i = 2; i <= num; i += 2) {
            System.out.println(i);
        }
    }

    public static void printOddNumbers(int num) {
        System.out.println("Odd Numbers : ");
        for(int i = 1; i <= num; i += 2) {
            System.out.println(i);
        }
    }

    public static void printFactorial(int num) {
        int product = 1;
        for(int i = 1; i <= num; i++) {
            product = product * i;
        }
        System.out.println("Factorial = " + product);
    }
}
