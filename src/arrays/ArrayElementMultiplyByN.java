package arrays;

import java.util.Scanner;

public class ArrayElementMultiplyByN {
    public static void main(String[] args) {
        int[] array = {7, 3, 6, 2, 4};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number to be multipled : ");
        int num = scanner.nextInt();
        multiplyByN(array, num);
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.print("\b\b.");
        scanner.close();
    }

    static void multiplyByN(int []arr, int n) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] = n * arr[i];
        }
    }
}
