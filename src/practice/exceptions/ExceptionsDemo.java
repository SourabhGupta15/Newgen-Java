package practice.exceptions;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionsDemo {
    public static void show() {
        // FileReader reader = null;
        try (
            var reader = new FileReader("file.txt");
            var writer = new FileWriter("...");
        ) {
            var value = reader.read();
            new SimpleDateFormat().parse("");
            System.out.println("File opened");
        }
        // catch (FileNotFoundException e) {
            //     System.out.println(e.getMessage());
            // }
        catch (IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
        // finally {
        //     if (reader != null) {
        //         try {
        //             reader.close();
        //         } catch (IOException e) {
        //             e.printStackTrace();
        //         }
        //     }
        // }
    }

    public static void show1() throws IOException {
        var account = new Account();
        
        // try {
        //     account.deposit(-1);
        // } catch (IOException e) {
        //     System.out.println("Logging");
        //     throw e;        // Rethrowing the exception
        // }

        try {
            account.withdraw(10);
        } catch (AccountException e) {
            // System.out.println(e.getMessage());
            // e.printStackTrace();
            var cause = e.getCause();
            System.out.println(cause.getMessage());
        }
    }
}
