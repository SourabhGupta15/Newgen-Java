package abstraction;

public interface Vehicle {
    public void run();
    public void fuel();
    public void roadTax();

    public static void abc() {
        System.out.println("Vehicle abc Static Method.");
    }

    public default void abc1() {
        System.out.println("Vehicle abc Default Method.");
    }
}
