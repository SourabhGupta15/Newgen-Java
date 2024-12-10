package oops;

public class TataNexon {
    int milage;
    String color;
    String owner; 
    
    void running() {
        System.out.println("The car is running.");
    }
    
    void washing() {
        System.out.println("This car needs to get a wash.");
    } 
    
    void service(){
        System.out.println("This car needs a service repair.");
    }

    void printObj() {
        System.out.println("Owner : " + this.owner + ", Mileage : " + this.milage + "kmpl, Colour : " + this.color);
    }

    public static void main(String[] args) {
        TataNexon car_201 = new TataNexon();
        car_201.owner = "Sagar";
        car_201.color = "Dark Gray";
        car_201.milage = 22;
        car_201.printObj();
        car_201.running();
        car_201.washing();
        car_201.service();
    }
}
