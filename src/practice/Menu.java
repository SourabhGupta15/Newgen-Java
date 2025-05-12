package practice;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("1. Option 1");
            System.out.println("2. Option 2");
            System.out.println("3. Option 3");
            System.out.println("4. Exit");
            System.out.print("Enter a number : ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You have chose option 1.");
                    break;
                
                case 2:
                    System.out.println("You have chose option 2.");
                    break;
            
                case 3:
                    System.out.println("You have chose option 3.");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Please enter a valid number.");
                    break;
            }
        }
    }
}
