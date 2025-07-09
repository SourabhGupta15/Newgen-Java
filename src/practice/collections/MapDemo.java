package practice.collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void show() {
        var c1 = new Customer("a", "e1");
        var c2 = new Customer("b", "e2");
        
        Map<String, Customer> map = new HashMap<>();
        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);

        // System.out.println(map.get("e10"));       //returns null if key not matched

        // var unknown = new Customer("Unknown", "");
        // System.out.println(map.getOrDefault("e10", unknown));       //sets the unknown as default value and returns it if key not matched.
        
        // System.out.println(map.containsKey("e10"));

        // map.replace("e1", new Customer("a++", "e1"));
        // System.out.println(map);

        // for (var key : map.keySet()) {
        //     System.out.println(key);
        // }

        // for (var entry : map.entrySet()) {
        //     System.out.println(entry);
        //     System.out.println(entry.getValue());
        //     System.out.println(entry.getKey());
        // }

        for (var customer : map.values()) {     //order is not guaranteed
            System.out.println(customer);
        }
    }
}
