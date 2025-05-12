package exceptionHandling.runTime;

import oops.Student;

public class Demo {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        try {
            int c = a/b;
            System.out.println("Division : " + c);
        } catch (ArithmeticException e) {
            System.out.println("b is zero, pls add vlaue of b other than zero for division : " + e.getMessage());
        }

        int d = a + b;
        System.out.println("sum : " + d);


        try {
            Student student = new Student();
            student = null;
            System.out.println(student.toString());     //Gives NullPointerException
        } catch (Exception e) {     //When you don't know what kind of exception it will throw, use Exception class
            System.out.println("Exception : " + e.getMessage());
        } finally {
            System.out.println("This is finally block.");
        }       // The statement inside finally block always gets executed whether there is exception or not. It is used for network or database or file closing.


        try {
            // ArithmeticException is a child of RunTimeException which is a child of Exception class. Follow the hierarchy.
            String str = null;
            System.out.println(str.trim());
            float c = a/b;
            System.out.println("Division : " + c);
            int[] arr = {1, 3, 4};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e2) {
            // Sibling Exception Classes can be written in any order. But the error that occurs first will be caught first.
            // Here NullPointer exception occurs first. So it will be caught first, no matter it is declared in above catch block or below.
            System.out.println("ArrayIndexOutOfBoundsException : " + e2.getMessage());
        } catch (ArithmeticException e) {
            // This is the right way of writing exceptions in multiple catch blocks. First child exception class and then parent exception class.
            System.out.println("ArithmeticException : " + e.getMessage());
        } catch (Exception e3) {
            // You can write multiple catch blocks.
            // But the parent classes of exception should be in the lower catch blocks.
            // Or otherwise the parent exceptions would catch the errors in above catch blocks and then there would be no use of writing child exception classes.
            // It gives compile time error.
            System.out.println("Exception : " + e3.getMessage());
        } finally {
            try {
                int f = 17/0;
            } catch (Exception e) {
                System.out.println("Exception : " + e.getMessage());
            }
        }

        // The best way is to write different try-catch blocks for different exceptions of different operations.
    }
}
