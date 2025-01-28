package exceptionHandling.throwThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import exceptionHandling.*;

public class Demo {
    public static void main(String[] args) throws Exception{    // Instead of FileNotFoundException, InvalidNamesException directly write Exception
        
        System.out.println("\nOperation 1");

        int result = addNumbers(6, -1);
        System.out.println("result : " + result);

        System.out.println("\nOperation 2");

        try {   // When adding the exception in the method signature, you have to surround the statement with try-catch block in which method is called or add throws exception in the main method signature.
            System.out.println("division : " + divideNumbers(7, 0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nOperation 3");

        System.out.println("multiplication : " + multiplyNumber(4, 3));

        System.out.println("\nOperation 4");

        System.out.println("Subtraction : " + subNumbers(8, 7));

        System.out.println("\nOperation 5");

        System.out.println("Last name : " + findLastName(null));

        System.out.println("\nOperation 6");

        readFile();     // Exception declared in main method signature.
    }

    private static int addNumbers(int a, int b) {
        // addNumbers() can accept only positive numbers. In case of negative numbers, it should throw an exception.
        if (a < 0 || b < 0) {
            throw new NegativeNumberException("Input argument numbers are negative.");   // Custom Exception
        }
        int c = a + b;
        return c;
    }

    private static int divideNumbers(int a, int b) throws Exception {   // This is method signature which contains method metadata i.e. all the personal information about the method.
        if (b <= 0) {
            throw new Exception("Divisor is less than or equal to zero.");
        }   // When throwing a checked exception such as above, always add Exception to method signature i.e. declare throws Exception in the method metadata or you can surround the throw new Exception() in a try-catch block.
        return a / b;
    }

    private static int multiplyNumber(int a, int b) {
        if (a <= 0 || b <= 0) {
            try {
                throw new Exception("Input numbers are less than equal to zero.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return a * b;
    }

    private static int subNumbers(int a, int b) {
        if (a < b) {
            // throw new RuntimeException("Subtrahend is greater than Minuend. Difference is negative.");
            throw new IllegalArgumentException("Subtrahend(b) is greater than Minuend(a). Difference is negative.");      // More specific Exception in this context. Child of RuntimeException. IllegalArgumentException extends RuntimeException.
            // throw new NumberFormatException("Subtrahend is greater than Minuend. Difference is negative.");     // Specific exception. Child of IllegalArgumentException. NumberFormatException extends IllegalArgumentException.
        }
        int c = a - b;
        return c;
    }

    private static String findLastName(String name) throws Exception {
        // try {
        //     if (name == null) {
        //         throw new InvalidNamesException("Input name is null.");     // Custom compile time Exception
        //     }
        // } catch (InvalidNamesException ie) {
        //     System.out.println("Exception at line 85 in method findLastName, message : " + ie.getMessage());
        // }
        if (name == null) {
            throw new InvalidNamesException("Input name is null.");     // Custom compile time Exception
        }
        String[] strArr = name.split(" ");
        if (strArr.length == 1) {
            throw new Exception("Please pass full name.");
        }
        return strArr[1];
    }

    @SuppressWarnings({ "resource", "unused" })
    private static void readFile() throws FileNotFoundException {
        File file = new File("D:\\file.txt");
        FileReader file1 = new FileReader(file);
    }
}
