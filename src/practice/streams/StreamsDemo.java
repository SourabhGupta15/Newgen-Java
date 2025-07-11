package practice.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void show() {
        List<Movie> movies = List.of(
            new Movie("a", 10),
            new Movie("b", 15),
            new Movie("c", 20)
        );

        // Imperative Programming
        // int count = 0;
        // for (var movie : movies)
        //     if (movie.getLikes() > 10)
        //         count++;

        // Functional Programming : It is a special type of Declarative Programming but it brings some additional concepts.
        // A stream is a sequence of objects, but it's not like a collection, it doesn't store data, it's just a way to get data out of the collection. You can think collection is like a water tank that is where we store the data and streams like a pipe to get water/data out of the water tank. Now we can attach one pipe after another and build a pipeline to transform data and get it out of the collection.

        var count2 = movies.stream()            //Declarative (Funtional) Programming
                           .filter(movie -> movie.getLikes() > 10)
                           .count();
        System.out.println(count2);
    }

    public static void showCreating() {
        // int[] numbers = {1, 2, 3};
        // Arrays.stream(numbers)       // arrays[] do not have streams() but Arrays do.
        //       .forEach(n -> System.out.println(n));

        // Creating stream from an arbitrary number of objects using Stream class.
        // Stream.of(1, 2, 3, "a", "b").forEach(e -> System.out.println(e));

        // Generating infinite streams
        // var stream = Stream.generate(() -> Math.random());   // Generate infinte stream of random numbers. At this line the function inside genrate() is not called. So nothing happens at this line. No number is generated. We don't have infinite numbers in the memory after this line is executed.
        // stream.limit(3).forEach(n -> System.out.println(n));     // The function inside generate is going to be called every time we read a number from the stream. The numbers are not generated ahead of time. This is called lazy evaluation. To prevent generating infinite times use limit() method.

        // To work with streams, we start off by creating a stream, then we apply one or more transformations on that stream and finally we call an operation that actually terminates that stream. So the forEach() in the above example terminates the string.

        // Generating streams using iterate() to generate finite or infinte streams.
        Stream.iterate(1, n-> n + 1)    // First parameter is seed which is a initial value and 2nd parameter is a unary operator that would modify its value.
              .limit(10)
              .forEach(n -> System.out.println(n));
    }

    public static void showMapping() {
        // var movies = List.of(
        //     new Movie("a", 10),
        //     new Movie("b", 20),
        //     new Movie("c", 30)
        // );

        // movies.stream()
        //       .map(movie -> movie.getTitle())
        //       .forEach(name -> System.out.println(name));
        
        // movies.stream()
        //       .mapToInt(movie -> movie.getLikes())       // Primitive variation of map()
        //       .forEach(likes -> System.out.println(likes));

        var stream = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6));
        // stream.forEach(list -> System.out.println(list));   // It return stream of list of integers

        stream.flatMap(list -> list.stream())
              .forEach(num -> System.out.println(num));     // Here flatMap() takes a Function that takes a list of integers an returns a stream of integers. With flatMap() we can flatten a stream of list objects to stream of objects. Stream<List<x>> -> Stream<x>. It doesn't have to be a list, we can have set, array, etc.
    }

    public static void showFiltering() {
        var movies = List.of(
            new Movie("a", 10),
            new Movie("b", 20),
            new Movie("c", 30)
        );

        Predicate<Movie> isPopular = movie -> movie.getLikes() > 10;
        
        movies.stream()
              .filter(isPopular)
              .forEach(movie -> System.out.println(movie.getTitle()));
    }

    public static void showSlicing() {
        var movies = List.of(
            new Movie("a", 10),
            new Movie("c", 30),
            new Movie("b", 20)
        );

        // movies.stream()
        //       .limit(2)      //Limits to first 2 items of the stream
        //       .forEach(movie -> System.out.println(movie.getTitle()));

        // movies.stream()
        //       .skip(2)      //Skips the first 2 items of the stream
        //       .forEach(movie -> System.out.println(movie.getTitle()));
        
        // We use these 2 methods so we can Paginate data. For e.g.
        // 1000 movies
        // 10 movies per page
        // For 3rd page skip 20 movies
        // First skip then limit page size to 10
        // movies.stream().skip(20).limit(10)

        // General formula for each page = skip( (page - 1) * pageSize)
        // General formula to limit to pageSize = limit(pageSize)

        // movies.stream()
        //       .takeWhile(movie -> movie.getLikes() < 30)
        //       .forEach(movie -> System.out.println(movie.getTitle()));      // As long as the Predicate inside takeWhile() returns true, takeWhile() returns an element. filter() iterates through whole stream whereas takeWhile() stops the moment it finds first element to contradict the condition and it doesn't matter if the elements ahead satisfies the condition. takeWhile() is more similar to while loop.

        movies.stream()
              .dropWhile(movie -> movie.getLikes() < 30)
              .forEach(movie -> System.out.println(movie.getTitle()));      // Drops/skips all the element until it finds the first element that does not matches the criteria. Similar to takeWhile() except dropWhile() skips.
    }

    public static void showSorting() {
        // By default the elements in the stream come in the same order as the underlying data source.
        var movies = List.of(
            new Movie("b", 10),
            new Movie("a", 20),
            new Movie("c", 40)
        );

        // movies.stream()
        //       .sorted()     // Using this we need to implement Comparable interface in Movie class and define there how we want to get our list sorted.
        //       .forEach(movie -> System.out.println(movie));

        // movies.stream()
        //       .sorted((movie1, movie2) -> movie1.getTitle().compareTo(movie2.getTitle()))
        //       .forEach(movie -> System.out.println(movie));
            // Here we use the Comparator interface as a Lambda expression in sorted() so we don't need to implement Comparable interface to Movie class.

        // movies.stream()
        //     //   .sorted(Comparator.comparing(movie -> movie.getTitle()))  // comparing() is a static method in Comparator interface. Similar to above but simpler.
        //       .sorted(Comparator.comparing(Movie::getTitle))    //Method referencing. More simpler.
        //       .forEach(movie -> System.out.println(movie));

        movies.stream()
              .sorted(Comparator.comparing(Movie::getTitle).reversed())     // Descennding order.
              .forEach(movie -> System.out.println(movie));
    }

    public static void showGetting() {      //Getting Unique Elements
        var movies = List.of(
            new Movie("a", 10),
            new Movie("d", 10),
            new Movie("b", 20),
            new Movie("c", 30)
        );

        movies.stream()
            //   .map(movie -> movie.getLikes())
              .map(Movie::getLikes)     //Method referencing.
              .distinct()       // Returns unique elements.
              .forEach(System.out::println);
    }

    public static void showPeeking() {
        // While working with complex queries we run into issues and may get the wrong result. To troubleshoot these issues we can use the peek().

        var movies = List.of(
            new Movie("a", 10),
            new Movie("b", 20),
            new Movie("c", 30)
        );

        movies.stream()
              .filter(movie -> movie.getLikes() > 10)
              .peek(movie -> System.out.println("filtered : " + movie.getTitle()))      //We can use the peek method to get the output of each operation.
              .map(Movie::getTitle)
              .peek(t -> System.out.println("mapped : " + t))
              .forEach(System.out::println);

        // peek() is an intermediate operation, we can use it to build a processing pipeline and forEach() is a terminal operation so it returns void. After forEach() we cannot call another method of the Stream class.
    }


    // Reducers : They reduce a stream of objects to a single object which is the answer we are looking for. They are terminal operations. Below are the group of operations called Reducers.

    public static void showSimpleReducers() {
        var movies = List.of(
            new Movie("a", 40),
            new Movie("b", 20),
            new Movie("c", 30)
        );

        var count = movies.stream()
                          .count();     //Returns the number of elements in a stream as primitive long value
        System.out.println(count);
              
        var result = movies.stream()
                           .anyMatch(movie -> movie.getLikes() > 20);  //Returns true if there is any element in the stream that satisfies the Predicate condition.
        System.out.println(result);

        result = movies.stream()
                           .allMatch(movie -> movie.getLikes() > 20);  //Returns true if all the elements in the stream satisfies the Predicate condition.
        System.out.println(result);

        result = movies.stream()
                           .noneMatch(movie -> movie.getLikes() > 20);  //Returns true if none of the elements in the stream satisfies the Predicate condition.
        System.out.println(result);

        var result1 = movies.stream()
                       .findFirst()     // Returns 1st element in stream as Optional<Movie> object.
                       .get();      // Returns the element as Movie object.
        System.out.println(result1.getTitle());

        result1 = movies.stream()
                       .findAny()     // Returns any element in stream as Optional<Movie> object.
                       .get();
        System.out.println(result1.getTitle());

        result1 = movies.stream()
                       .max(Comparator.comparing(Movie::getTitle))     // Returns maximum element in stream based on Comparator provided as Optional<Movie> object.
                       .get();
        System.out.println(result1.getTitle());

        result1 = movies.stream()
                       .min(Comparator.comparing(Movie::getLikes))     // Returns minimum element in stream based on Comparator provided as Optional<Movie> object.
                       .get();
        System.out.println(result1.getTitle());
    }

    public static void showReducing() {
        var movies = List.of(
            new Movie("a", 10),
            new Movie("b", 20),
            new Movie("c", 30)
        );

        // General purpose reduction operation to reduce whole stream to a single value.

        // Optional<Integer> sum = movies.stream()
        //                               .map(movie -> movie.getLikes())
        //                               .reduce((a, b)-> a + b);     // Here we pass BinaryOperator which we call an accumulator and the job of this accumulator is to accumulate values. Reduce returns Optional object.
        // In the above example after map we get stream of [10, 20, 30]; then after reduce we get[30, 30] and then again reduce to [60].

        // sum.get();      // If we have a value we can use the get() but if we don't then it will throw an exception.

        // System.out.println(sum.orElse(0));      // orElse() prevents the exception but we have to supply a default value if there is no value present.

        // Optional<Integer> sum1 = movies.stream()
        //                                .map(movie -> movie.getLikes())
        //                                .reduce(Integer::sum);      // Integer class has a static method called sum().
        // System.out.println(sum1.orElse(0));

        Integer sum2 = movies.stream()
                             .map(Movie::getLikes)
                             .reduce(0, Integer::sum);      // Here we provide a default Integer value so we don't have to deal with Optional class.
        System.out.println(sum2);
    }

    public static void showCollectors() {
        var movies = List.of(
            new Movie("a", 10),
            new Movie("b", 20),
            new Movie("c", 30)
        );

        var result = movies.stream()
                           .filter(movie -> movie.getLikes() > 10)
                           .collect(Collectors.toList());      // Here collect() takes a Collector interface object. Collector is used to convert a stream into list, map, set, etc.. Collectors is a utility class but it does not implements Collector interface; it simply provides static factory methods to create commonly used Collector object. Here toList() returns instance of the Collector interface that knows how to convert a Stream<Movie> into a List<Movie>.

        var result1 = movies.stream()
                       .filter(movie -> movie.getLikes() > 10)
                       .collect(Collectors.toSet());    // Converts Stream<Movie> to Set<Movie>
                       
        var result2 = movies.stream()
                        .filter(movie -> movie.getLikes() > 10)
                        .collect(Collectors.toMap(Movie::getTitle, Movie::getLikes));    // Here we need to provide what should be key and what should be value. Here we get a HashMap. Converts Stream<Movie> to Map<String, Integer>.

        var result3 = movies.stream()
                        .filter(movie -> movie.getLikes() > 10)
                        .collect(Collectors.toMap(Movie::getTitle, movie -> movie));    // Returns Map<String, Movie>

        result3 = movies.stream()
                        .filter(movie -> movie.getLikes() > 10)
                        .collect(Collectors.toMap(Movie::getTitle, Function.identity()));    // Returns Map<String, Movie>. Function interface is a functional interface.

        var result4 = movies.stream()
                            .filter(movie -> movie.getLikes() > 10)
                            .collect(Collectors.summingInt(Movie::getLikes));    // With this we can sum up the number of like of all the movies. Instead of reduce(). We can also use summingDouble() which returns Double or summingLong() for returning Long.

        var result5 = movies.stream()
                            .filter(movie -> movie.getLikes() > 10)
                            .collect(Collectors.summarizingInt(Movie::getLikes));   // This gives the statistics about the values in our stream. Also available Long and Double versions.

        var result6 = movies.stream()
                            .filter(movie -> movie.getLikes() > 10)
                            .map(Movie::getTitle)
                            .collect(Collectors.joining(", "));     //Concatenate strings

        System.out.println(result6);
    }

    public static void showGrouping() {
        // Group or Classify a data by their type for example a movie genre.

        var movies = List.of(
            new Movie("a", 10, Genre.THRILLER),
            new Movie("b", 20, Genre.ACTION),
            new Movie("c", 30, Genre.ACTION)
        );

        var result = movies.stream()
                           .collect(Collectors.groupingBy(Movie::getGenre));       // groupingBy() takes a classifier which is Function that takes an object and determines how we are going to classify or group our data. It returns Map<Genre, List<Movie>>

        var result1 = movies.stream()
                           .collect(Collectors.groupingBy(
                                    Movie::getGenre, Collectors.toSet()));      // Now it returns Map<Genre, Set<Movie>>

        var result2 = movies.stream()
                           .collect(Collectors.groupingBy(
                                    Movie::getGenre, Collectors.counting()));      // Now it returns Map<Genre, Long>. counting() give count in each genre.

        var result3 = movies.stream()
                            .collect(Collectors.groupingBy(
                                    Movie::getGenre,
                                    Collectors.mapping(
                                        Movie::getTitle,
                                        Collectors.joining(", "))));    // joining() only works on Stream<String>. So we use mapping().
        System.out.println(result3);
    }

    public static void showPartitioning() {
        // Partition our data based on some condition
        var movies = List.of(
            new Movie("a", 10, Genre.THRILLER),
            new Movie("b", 20, Genre.ACTION),
            new Movie("c", 30, Genre.ACTION)
        );

        var result = movies.stream()
                           .collect(Collectors.partitioningBy(
                                        movie -> movie.getLikes() > 20));     // Returns a Map<Boolean, List<Movies>>

        var result1 = movies.stream()
                            .collect(Collectors.partitioningBy(
                                   movie -> movie.getLikes() > 20, 
                                   Collectors.mapping(Movie::getTitle,
                                                    Collectors.joining(", "))));    // Returns  Map<Boolean, String>
        System.out.println(result1);
    }

    public static void showPrimitveTypeStream() {
        IntStream.rangeClosed(1, 5)
                .forEach(System.out::println);      // Prints 1 to 5.
                
        IntStream.range(1, 5)
                .forEach(System.out::println);      // Prints 1 to 4.

        // There are IntStream, LongStream and DoubleStream. All operations on Stream are applicable on them and they have some additional operations specific to them such as range() and rangeClosed().
    }
}
