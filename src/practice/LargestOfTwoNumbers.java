/* Write a Java code to find the largest of two numbers.
 * int num1
 * int num2
 * hint -> num1>num2
*/

package practice;

import java.util.Scanner;

public class LargestOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the First Number : ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the Second Number : ");
        int num2 = scanner.nextInt();
        findlargest(num1, num2);
        scanner.close();
    }

    public static void findlargest(int a, int b) {
        if(a > b) {
            System.out.println(a + " is larger than " + b + ".");
        } else if(a < b) {
            System.out.println(b + " is larger than " + a + ".");
        } else {
            System.out.println("Both numbers are same.");
        }
    }
}
