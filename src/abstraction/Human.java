package abstraction;

public abstract class Human {

    public abstract void eat();     //Method Hiding

    public void run() {
        System.out.println("Human Running.");
    }

    public static void sleep() {
        System.out.println("Human is Sleeping.");
    }

    public final void walk() {
        System.out.println("Human is Walking.");
    }
}
