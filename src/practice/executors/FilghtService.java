package practice.executors;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class FilghtService {
    public Stream<CompletableFuture<Quote>> getQuotes() {
        var sites = List.of("site1", "site2", "site3");

       return sites.stream().map(this::getQuote);       // Returns Stream<CompletableFuture<Quote>>
    }

    public CompletableFuture<Quote> getQuote(String site) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting a quote form " + site);
            
            var random = new Random();

            LongTask.simulate(1_000 + random.nextInt(2_000));       // Randomly delaying between 1 to 3 seconds

            var price = 100 + random.nextInt(10);       // To get price between 100 and 110.

            return new Quote(site, price);
        });
    }
}
