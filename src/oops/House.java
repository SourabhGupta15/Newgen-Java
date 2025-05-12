package oops;

public class House {
    String address;
    String name;
    int number;
    String color;

    void living() {
        System.out.println("We're living in the house.");
    }

    void onRent() {
        System.out.println("It is on rent.");
    }

    void print() {
        System.out.println("Name : " + this.name + ", Address : " + this.address + ", Number : " + this.number + ", Color : " + this.color);
    }

    void assignValues(String name, String address, int number, String color) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.color = color;
    }

    public static void main(String[] args) {
        House flat_201 = new House();
        flat_201.address = "Bandra, Mumbai";
        flat_201.name = "Mannat";
        flat_201.number = 201;
        flat_201.color = "Grey";
        flat_201.print();
        flat_201.living();
 
        House flat_202 = new House();
        flat_202.assignValues("Antilia", "Mumbai", 202, "White");
        flat_202.print();

        House flat_203 = new House();
        flat_203.assignValues("Jalse", "Juhu", 203, "Cream");
        flat_203.print();
        flat_203.onRent();
    }
}
