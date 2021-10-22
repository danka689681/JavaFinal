package nl.inholland.javafx.endassignment;

import java.util.ArrayList;
import java.util.List;

public class StreamingDatabase {
    public static void createStream(List room1, String startDate, String startTime, String endDate, String endTime, String title, int seats, double price, List rooms, int duration) {
        Stream newMovie = new Stream((startDate + " " + startTime), (endDate + " " + endTime), startDate, startTime, endDate, endTime, title, seats, price, duration);
        room1.add(newMovie);
        rooms.add(newMovie);
    }

    public List<Stream> room1 = new ArrayList<>();
    public List<Stream> room2 = new ArrayList<>();
    public List<Stream> rooms = new ArrayList<>();


    public StreamingDatabase() {
        createStream(room1, "09-10-2021", "22:30","10-10-2021", "00:00", "movie in room 1", 150, 11.00, rooms, 90);
        createStream(room1, "09-10-2021", "12:30","09-10-2021", "15:00", "The Giver", 150, 15.00, rooms, 150);
        createStream(room2, "09-10-2021","20:00", "09-10-2021", "21:00", "some other movie", 200, 12.00, rooms, 60);
    }

    public int getRoomsIndex(String title) {
        for (Stream i : rooms) {
            if (title.equals(i.getTitle())) {
                return rooms.indexOf(i);
            }
        }
        return 0;
    }

    public int getRoom1Index(String title) {
        for (Stream i : room1) {
            if (title.equals(i.getTitle())) {
                return room1.indexOf(i);
            }
        }
        return 0;
    }

    public int getRoom2Index(String title) {
        for (Stream i : room2) {
            if (title.equals(i.getTitle())) {
                return room2.indexOf(i);
            }
        }
        return 0;
    }
    public List<Stream> getWholeDatabase() {
       return rooms;
    }

    public List<Stream> getRoom1() {
        return room1;
    }
    public List<Stream> getRoom2() {
        return room2;
    }
    public List<String> getTitle() {
        List<String> title = new ArrayList<>();

        for (Stream i : room1) {
            title.add(i.getTitle());
        }
        for (Stream i : room2) {
            title.add(i.getTitle());
        }
        return title;
    }

}