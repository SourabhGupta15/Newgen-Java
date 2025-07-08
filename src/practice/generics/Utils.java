package practice.generics;

public class Utils {
    public static <T extends Comparable<T>> T max(T first, T second) {
        return (first.compareTo(second) < 0) ? second : first;
    }

    public static <K, V> void print(K key, V value) {
        System.out.println(key + " = " + value);
    }

    public static void printUser(User user) {
        System.out.println(user);
    }

    public static void printUsers(GenericList<? extends User> users) {    // ? refers to wildcard. This wildcard represents an unknown type.
        User x = users.get(0);                                      // extends gives child of User class.

    }

    public static void printUsers1(GenericList<? super User> users) {   // super keyword gives Parent of User class
        users.add(new Instructor(20));
        Object x = users.get(0);
    }
}
