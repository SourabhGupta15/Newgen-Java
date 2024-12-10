package practice;

import java.util.Scanner;

public class WhileLoopExamples {
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
        int i = 1;
        while(i <= num) {
            System.out.println(i);
            i++;
        }
    }

    public static void printSumOfNumbers(int num) {
        int i = 1;
        int sum = 0;
        while(i <= num) {
            sum += i;
            i++;
        }
        System.out.println("Sum = " + sum);
    }

    public static void printEvenNumbers(int num) {
        System.out.println("Even Numbers : ");
        int i = 2;
        while(i <= num) {
            System.out.println(i);
            i += 2;
        }
    }

    public static void printOddNumbers(int num) {
        System.out.println("Odd Numbers : ");
        int i = 1;
        while(i <= num) {
            System.out.println(i);
            i += 2;
        }
    }

    public static void printFactorial(int num) {
        int product = 1;
        int i = 2;
        while (i <= num) {
            product = product * i;
            i++;
        }
        System.out.println("Factorial = " + product);
    }
}
