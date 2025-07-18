package practice.streams;

public class Movie implements Comparable<Movie> {
    private String title;
    private int likes;
    private Genre genre;

    public Movie(String title, int likes, Genre genre) {
        this.title = title;
        this.likes = likes;
        this.genre = genre;
    }

    public Movie(String title, int likes) {
        this.title = title;
        this.likes = likes;
    }

    public int getLikes() {
        return likes;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public int compareTo(Movie other) {
        return title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return title + "=" + likes ;
    }
}
