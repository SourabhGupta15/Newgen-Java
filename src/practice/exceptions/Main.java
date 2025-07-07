package practice.exceptions;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // ExceptionsDemo.show();
        try {
            ExceptionsDemo.show1();
        } catch (Throwable e) {
            System.out.println("An unexpected error occurred.");
        }
    }
}
