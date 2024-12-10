package practice;

public class Swap {
    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        System.out.println("Before swapping,\na : " + a + ", b : " + b);
        swapOne(a,b);
        swapTwo(a,b);
    }

    static void swapOne(int numa, int numb) {
        int c = numa;
        numa = numb;
        numb = c;
        System.out.println("After swapping,\na : " + numa + ", b : " + numb);
    }

    static void swapTwo(int numa, int numb) {
        numb = numb + numa;
        numa = numb - numa;
        numb = numb - numa;
        System.out.println("After swapping,\na : " + numa + ", b : " + numb);
    }
}
