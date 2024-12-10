package practice;

import java.util.Scanner;

public class WeekDays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Number : ");
        int number = scanner.nextInt();
        printDays(number);
        scanner.close();
    }

    public static void printDays(int number) {
        switch (number) {
            case 1:
                System.out.println("Monday");
                break;
        
            case 2:
                System.out.println("Tueday");
                break;
        
            case 3:
                System.out.println("wednesday");
                break;
        
            case 4:
                System.out.println("Thursday");
                break;
        
            case 5:
                System.out.println("Friday");
                break;
        
            case 6:
                System.out.println("Saturday");
                break;
        
            case 7:
                System.out.println("Sunday");
                break;
        
            default:
                System.out.println("Please enter the correct number between 1 to 7.");
        }
    }
}
