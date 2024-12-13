package abstraction;

public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        car.run();
        car.fuel();
        car.roadTax();
        car.abc1();
        Vehicle.abc();

        Boys boys = new Boys();
        boys.eat();
        boys.run();
        Boys.sleep(); //or Human.sleep(); //It is a static method.
        boys.walk();
    }
}
