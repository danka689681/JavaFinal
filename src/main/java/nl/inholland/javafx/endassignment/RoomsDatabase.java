package nl.inholland.javafx.endassignment;

import java.util.ArrayList;
import java.util.List;

public class RoomsDatabase {
    public static void createRoom(List roomsData, String name, int capacity) {
        Rooms newRooms = new Rooms(name, capacity);
        roomsData.add(newRooms);
    }

    public List<Rooms> roomsData = new ArrayList<>();



    public RoomsDatabase() {
        createRoom(roomsData, "Room 1", 150);
        createRoom(roomsData, "Room 2", 200);
    }

    public List<Rooms> getRoomsData() {
        return roomsData;
    }

    public int getRoomsDataIndex(String name) {
        for (Rooms i : roomsData) {
            if (name.equals(i.getName())) {
                return roomsData.indexOf(i);
            }
        }
        return 0;
    }


    public void setRoomsData(List<Rooms> roomsData) {
        this.roomsData = roomsData;
    }
}