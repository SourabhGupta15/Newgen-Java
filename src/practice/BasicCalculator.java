package practice;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, output = 0.0;
        char op;

        System.out.println("Enter the numbers :");
        num1 = scanner.nextDouble();
        num2 = scanner.nextDouble();
        
        System.out.print("Enter the operator : ");
        op = scanner.next().charAt(0);      // .next() is used to acquire the first string between spaces.
        
        switch (op) {
            case '+':
                output = num1 + num2;
                break;

            case '-':
                output = num1 - num2;
                break;

            case '*':
                output = num1 * num2;
                break;

            case '/':
                output = num1 / num2;
                break;
        
            default:
                System.out.println("Please enter correct operator.");
                break;
        }

        System.out.println("Output : " + output);

        scanner.close();
    }
}
