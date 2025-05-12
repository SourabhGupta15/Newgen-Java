package map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        Map<String, Double> tm = new TreeMap<>();

        tm.put("Zara", 3434.34d);
        tm.put("Mahnaz", 123.22);
        tm.put("Ayan", new Double(1378));
        tm.put("Daisy", new Double(99.22));
        tm.put("Qadir", new Double(-19.08));
        tm.put("Qadir", 444444.00);

        tm.put("Rahul", null);
        tm.put("Rekha", 41.0);
        tm.put("Rohan", 51.0);
        tm.put("Snehal", null);
        tm.put("Zara", 44.44);

        // for (Map.Entry<String, Double> entry : tm.entrySet()) {
        //     System.out.println(entry.getKey() + " : " + entry.getValue());
        // }

        tm.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}
