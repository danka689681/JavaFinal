package nl.inholland.javafx.endassignment;

import java.util.ArrayList;
import java.util.List;

public class MoviesDatabase {
    public static void createMovie(List room, String start, String end, String title, int seats, double price) {
        Movie newMovie = new Movie(start, end, title, seats, price);
        room.add(newMovie);
    }

    private List<Movie> room1 = new ArrayList<>();
    private List<Movie> room2 = new ArrayList<>();

    public MoviesDatabase() {
        createMovie(room1, "09-10-2021 22:30","09-10-2021 00:02", "movie in room 2", 150, 15.00);
        createMovie(room2, "09-10-2021 20:00", "09-10-2021 20:05", "some other movie", 200, 12.00);
    }
    public List<Movie> getRoom1() {
        return room1;
    }
    public List<Movie> getRoom2() {
        return room1;
    }

}