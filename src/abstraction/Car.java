package abstraction;

public class Car implements Vehicle {
    
    @Override
    public void run() {
        System.out.println("This is Run Method.");
    }

    @Override
    public void fuel() {
        System.out.println("This is Fuel Method.");
    }

    public void roadTax() {
        System.out.println("Road Tax Method.");
    }
}
