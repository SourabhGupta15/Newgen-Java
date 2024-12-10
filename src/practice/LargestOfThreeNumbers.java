/* Write a Java code to find the largest of three numbers.
 *  int num1
 *  int num2
 *  int num3
*/

package practice;

import java.util.Scanner;

public class LargestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the First Number : ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the Second Number : ");
        int num2 = scanner.nextInt();
        System.out.print("Enter the Third Number : ");
        int num3 = scanner.nextInt();
        findlargest(num1, num2, num3);
        scanner.close();
    }

    public static void findlargest(int a, int b, int c) {
        if(a > b && a > c) {
            System.out.println(a + " is larger than " + b + " and " + c + ".");
        } else if(b > a && b > c) {
            System.out.println(b + " is larger than " + a + " and " + c + ".");
        } else if(c > a && c > b) {
            System.out.println(c + " is larger than " + a + " and " + b + ".");
        }
    }
}
