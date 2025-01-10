package exceptionHandling.compileTime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Demo {
    public static void main(String[] args) {
        try {
            File file = new File("E://file.txt");
            FileReader file1 = new FileReader(file);
            System.out.println(file1);
        } catch (FileNotFoundException f) {
            System.out.println("FileNotFoundException : " + f.getMessage());
        }
    }
}
