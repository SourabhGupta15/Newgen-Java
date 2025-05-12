package practice;

import java.util.Scanner;

public class NestedForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter any Number : ");
        int num = scanner.nextInt();
        squarePattern(num);
        rectangleHorizontalPattern(num);
        rectangleVerticalPattern(num);
        pyramidPattern(num);
        pyramidReversePattern(num);
        scanner.close();
    }

    static void squarePattern(int n) {
        System.out.println("Square Pattern : ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void rectangleVerticalPattern(int n) {
        System.out.println("Rectangle Vertical Pattern : ");
        for(int i = 0; i < n * 2; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void rectangleHorizontalPattern(int n) {
        System.out.println("Rectangle Horizontal Pattern : ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n * 2; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pyramidPattern(int n) {
        System.out.println("Pyramid Pattern : ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pyramidReversePattern(int n) {
        System.out.println("Pyramid Reverse Pattern : ");
        for(int i = 0; i < n; i++) {
            for(int j = n; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
