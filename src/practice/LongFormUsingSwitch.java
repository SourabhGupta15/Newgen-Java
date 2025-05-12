package practice;

import java.util.Scanner;

public class LongFormUsingSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Company name : ");
        String name = scanner.nextLine().toLowerCase();
        printCompanyName(name);
        scanner.close();
    }

    public static void printCompanyName(String name) {
        switch (name) {
            case "tcs":
                System.out.println("Tata Consultancy Services");
                break;
        
            case "cg":
                System.out.println("Capgemini");
                break;
        
            case "fb":
                System.out.println("FaceBook");
                break;
        
            default:
                System.out.println("Please enter the correct input.");
        }
    }
}
