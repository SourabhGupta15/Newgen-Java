package practice.generics;

public class Main {
    public static void main(String[] args) {
        // var user1 = new User(10);
        // var user2 = new User(20);

        // if (user1.compareTo(user2) < 0)
        //     System.out.println("user1 < user2");
        // else if (user1.compareTo(user2) == 0)
        //     System.out.println("user1 == user2");
        // else
        //     System.out.println("user1 > user2");

        // System.out.println(Utils.max(user1, user2));

        // Utils.print(1, "Hello");

        // User user = new Instructor(10);
        // Utils.printUser(user);

        // var instructors = new GenericList<Instructor>();
        // var users = new GenericList<User>();
        // Utils.printUsers(new GenericList<Instructor>());
        // Utils.printUsers(new GenericList<User>());

        var list = new GenericList<String>();
        list.add("a");
        list.add("b");

        // var iterator = list.iterator();
        // while (iterator.hasNext()) {
        //     var current = iterator.next();
        //     System.out.println(current);
        // }

        for (var item : list) {
            System.out.println(item);
        }
    }
}
