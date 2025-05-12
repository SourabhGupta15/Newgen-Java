//4: Reverse a string without using arrays
package practice;

import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String word = scanner.nextLine();
        String reversed = printReverse(word);
        System.out.println("Reverse of String : " + reversed);
        scanner.close();
    }

    static String printReverse(String word) {
        String reversed = "";
        for(int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }
        return reversed;
    }
}