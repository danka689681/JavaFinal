package nl.inholland.javafx.endassignment;

import java.util.ArrayList;
import java.util.List;

public class MoviesDatabase {
    public static void createMovie(List movies, String title, double price, int duration) {
        Movie newMovie = new Movie(title, price, duration);
        movies.add(newMovie);
    }

    public List<Movie> movies = new ArrayList<>();

    public MoviesDatabase() {
        createMovie(movies, "movie in room 1",  11.00,  90);
        createMovie(movies, "The Giver",  15.00,  150);
        createMovie(movies,  "some other movie", 12.00,  60);
    }

    public int getMovieIndex(String title) {
        for (Movie i : movies) {
            if (title.equals(i.getTitle())) {
                return movies.indexOf(i);
            }
        }
        return 0;
    }

    public List<Movie> getWholeDatabase() {
       return movies;
    }

    public List<String> getTitle() {
        List<String> title = new ArrayList<>();
        for (Movie i : movies) {
            title.add(i.getTitle());
        }
        return title;
    }


}