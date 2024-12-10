package practice;

import java.util.*;
import java.net.*;

public class TimeAndDate {
    public static void main(String[] args) throws Exception{
        Date time = new Date();
        System.out.printf("Current Time : %tT%n", time);
        // System.out.printf("Hours: %tH Minutes: %tM Seconds: %tS\n", time, time, time);
        // System.out.printf("%1$tH:%1$tM:%1$tS %1$tp %1$tL millisec %1$tN nanosec %1$tz %n", time);
        // System.out.printf("Current Date : %tD%n", time);
        // System.out.printf("Current Day : %td%n", time);
        // System.out.printf("Current Month : %tm%n", time);
        // System.out.printf("Current Year : %TY%n", time);
        @SuppressWarnings("deprecation")
        URL myURL= new URL("https://dzone.com/articles/java-string-format-examples");
        System.err.println("Refer this for Format Specifiers : " + myURL.toString());
    }
}
