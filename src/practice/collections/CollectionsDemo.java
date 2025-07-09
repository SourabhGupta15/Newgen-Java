package practice.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsDemo {
    public static void show() {
        Collection<String> collection = new ArrayList<>();
        // collection.add("a");
        // collection.add("b");
        // collection.add("c");
        // for (var item : collection) {
        //     System.out.println(item);
        // }

        Collections.addAll(collection, "a", "b", "c");
        // System.out.println(collection.size());
        // collection.remove("a");
        // collection.clear();
        // System.out.println(collection.isEmpty());
        // System.out.println(collection.contains("a"));
        // System.out.println(collection);

        // var objectArray = collection.toArray();
        // var stringArray = collection.toArray(new String[0]);

        Collection<String> other = new ArrayList<>();
        other.addAll(collection);

        System.out.println(collection == other);        //both objects refer to different memory location
        System.out.println(collection.equals(other));   //both have the same content
    }
}
