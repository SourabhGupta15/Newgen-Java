package map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Map<String, Double> lhm = new LinkedHashMap<>();

        lhm.put("Zara", 3434.34d);
        lhm.put("Mahnaz", 123.22);
        lhm.put("Ayan", new Double(1378));
        lhm.put("Daisy", new Double(99.22));
        lhm.put("Qadir", new Double(-19.08));
        lhm.put("Qadir", 444444.00);

        lhm.put(null, 11.11);
        lhm.put(null, 22.22);
        lhm.put(null, 33.33);
        lhm.put("Rahul", null);
        lhm.put("Rekha", 41.0);
        lhm.put("Rohan", 51.0);
        lhm.put("Snehal", null);
        lhm.put("Zara", 44.44);

        for (Map.Entry<String, Double> entry : lhm.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
