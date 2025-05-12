/* Write a Java code to check if a person is eligible for a job based on their age and experience.
 *  age >= 25
 *  experience >= 3
*/

package practice;

import java.util.Scanner;

public class JobEligibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Age : ");
        int age = scanner.nextInt();
        System.out.print("Enter Experience : ");
        int experience = scanner.nextInt();
        Eligibility(age, experience);
        scanner.close();
    }

    public static void Eligibility(int age, int experience) {
        if(age >= 25) {
            if (experience >= 3) {
                System.out.println("This person is eligible for a Job.");
            } else {
                System.out.println("This person is not eligible for Job due to less Experience.");
            }
        } else {
            System.out.println("This person is not eligible for Job due to less Age.");
        }
    }
}
