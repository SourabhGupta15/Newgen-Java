package abstraction;

public class Boys extends Human {
    
    @Override
    public void eat() {
        System.out.println("Boys Eat");
    }

    public void run() {     //Method Overriding
        System.out.println("Boys Running");
    }
}
