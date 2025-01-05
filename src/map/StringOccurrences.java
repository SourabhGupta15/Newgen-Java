package map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringOccurrences {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        Map<String, Integer> stringCountMap = new HashMap<>();

        for (String str : strings) {
            if (stringCountMap.containsKey(str)) {
                stringCountMap.put(str, stringCountMap.get(str)+1);
            } else {
                stringCountMap.put(str, 1);
            }
        }
        
        // for (Map.Entry<String, Integer> entry : stringCountMap.entrySet()) {
        //     System.out.println(entry.getKey() + " : " + entry.getValue());
        // }

        // stringCountMap.forEach((k, v) -> System.out.println(k + " : " + v));    //Printing Map using lambda expression
        
        stringCountMap.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue())); //Printing using stream API
    }
}
