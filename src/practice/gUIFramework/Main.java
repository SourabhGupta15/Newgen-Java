package practice.gUIFramework;

public class Main {
    public static void main(String[] args) {
        // var control = new UIControl(true);
        // var textBox = new TextBox(); 

        // textBox.setText("Hello World");
        // System.out.println(textBox);

        // show(control);
        // show(textBox);

        // System.out.println(textBox.equals(box2));
        //returns hashcode(numeric value) which is calculated based on the address of the object present in the memory. It is not the actual address. The address goes to a hash function and hashcode() gets a value and maps it to a numeric value which is called hash. The hashcode is used in a lot of situations such as comparing objects for equality.
        
        // var point1 = new Point(1, 2);
        // var point2 = new Point(1, 2);
        // System.out.println(point1.equals(point2));
        // System.out.println(point1.hashCode());
        // System.out.println(point2.hashCode());

        UIControl[] controls = {new TextBox(), new CheckBox()};
        for (var control : controls) {
            control.render();
        }
    }

    public static void show(UIControl control) {
        if (control instanceof TextBox) {
            var textBox = (TextBox) control;
            textBox.setText("Hello World");
        }
        System.out.println(control);
    }
}
