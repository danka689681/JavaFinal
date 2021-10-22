package nl.inholland.javafx.endassignment;

import java.util.LinkedHashMap;
import java.util.Map;

public class Rooms {
    protected String name;
    protected int capacity;

    public Rooms(String name, int capacity) {
       this.name = name;
       this.capacity = capacity;
    }

    public String toString() {
        return String.valueOf(this.capacity);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}