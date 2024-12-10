package practice;

import java.util.Scanner;

/**
 * @author Sourabh
 * @since 2024-11-19
 * @version 1.0
 */
public class DoWhileLoopExamples {
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

    /**
     * Takes a postive number and prints numbers from 1 to that number.
     * <p>
     * If the number is negative then it prints only one.
     * @param num The value of the number.
     * @return Nothing
     */
    public static void printNumbers(int num) {
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while(i <= num);
    }

    public static void printSumOfNumbers(int num) {
        int i = 1;
        int sum = 0;
        do {
            sum += i;
            i++;
        } while(i <= num);
        System.out.println("Sum = " + sum);
    }

    public static void printEvenNumbers(int num) {
        System.out.println("Even Numbers : ");
        int i = 2;
        do {
            System.out.println(i);
            i += 2;
        } while(i <= num);
    }

    public static void printOddNumbers(int num) {
        System.out.println("Odd Numbers : ");
        int i = 1;
        do {
            System.out.println(i);
            i += 2;
        } while(i <= num) ;
    }

    public static void printFactorial(int num) {
        int product = 1;
        int i = 2;
        do {
            product = product * i;
            i++;
        } while (i <= num);
        System.out.println("Factorial = " + product);
    }
}
