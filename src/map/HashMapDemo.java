package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Double> hm = new HashMap<>();

        hm.put("Zara", 3434.34d);
        hm.put("Mahnaz", 123.22);
        hm.put("Ayan", new Double(1378));
        hm.put("Daisy", new Double(99.22));
        hm.put("Qadir", new Double(-19.08));
        hm.put("Qadir", 444444.00);

        hm.clear();

        hm.put(null, 11.11);
        hm.put(null, 22.22);
        hm.put(null, 33.33);
        hm.put("Rahul", null);
        hm.put("Rekha", 41.0);
        hm.put("Rohan", 51.0);
        hm.put("Snehal", null);
        hm.put("Zara", 44.44);

        System.out.println("hm : " + hm);
        
        // For printing Map on different lines convert it to set
        Set<Map.Entry<String, Double>> entries = hm.entrySet();
        
        for (Map.Entry<String,Double> entry : entries) {
            System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
        }
        
        System.out.println("\nhm.isEmpty() : " + hm.isEmpty());

        System.out.println("\nFilter Map");
        for (Map.Entry<String,Double> entry : entries) {
            if (entry.getKey() != null && entry.getKey().equals("Rahul")) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }

        System.out.println("\nFilter Map");
        for (Map.Entry<String,Double> entry : entries) {
            if (entry.getKey() != null && entry.getKey().startsWith("R")) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
