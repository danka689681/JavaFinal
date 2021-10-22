package nl.inholland.javafx.endassignment;

import java.util.LinkedHashMap;
import java.util.Map;

public class Movie{
    private String title;
    private double price;
    private int duration;
    private int index;

    public Movie(String title, double price, int duration) {
        this.title = title;
        this.price = price;
        this.duration = duration;
    }


    public String toString() {
        return this.title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}