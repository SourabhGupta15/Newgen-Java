package staticKeyword;

public class StaticBlock {
    static int b;

    static {
        System.out.println("Welcome to Static Block.");
        b = 12;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Main Method.");
        System.out.println(StaticBlock.b);
        StaticBlock.b = 13;
        System.out.println(StaticBlock.b);
    }
}
