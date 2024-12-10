/* Write a Java code to check if a person is eligible for a vote based on their age
 *  age >= 18 then eligible for vote
*/

package practice;

import java.util.Scanner;

public class Vote {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age : ");
        int age = scanner.nextInt();
        Eligibility(age);
        scanner.close();
    }

    public static void Eligibility(int age) {
        if(age >= 18) {
            System.out.println("This person is eligible to Vote.");
        } else {
            System.out.println("This person is not eligible to Vote.");
        }
    }
}
