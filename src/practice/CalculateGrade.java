/* Q1. WAP to calculate grade basis on the marks
marks < 40 then Fail
40 <= marks < 55  - Pass
55 <= marks < 60  - Second Class 
60 <= marks < 65 - First Class
65 <= marks Distinction
*/

package practice;

import java.util.Scanner; //importing Scanner directory

public class CalculateGrade {
    public static void main(String[] args){
        System.out.print("Enter a number : "); // println for printing a line and print for only printing the text
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt(); // for scanning integer input
        calculateGrade(number);
        scanner.close(); // to close the scanner
    }

    public static void calculateGrade(int marks){
        if(marks < 40){
            System.out.println("Fail");
        } else if(marks < 55) {
            System.out.println("Pass");
        } else if(marks < 60) {
            System.out.println("Second Class");
        } else if(marks < 65) {
            System.out.println("First Class");
        } else {
            System.out.println("Distinction");
        }
    }
}
