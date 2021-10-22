package nl.inholland.javafx.endassignment;

import java.util.LinkedHashMap;
import java.util.Map;

public class Stream {
    private Map<String, String> start;
    private Map<String, String> end;
    private String startString;
    private String endString;
    private String title;
    private int seats;
    private double price;
    private int duration;
    private int index;

    public Stream(String startString, String endString, String startDate, String startTime, String endDate, String endTime, String title, int seats, double price, int duration) {
        start = new LinkedHashMap<>();
        start.put("startDate", startDate);
        start.put("startTime", startTime);
        this.startString = startString;
        this.endString = endString;
        end = new LinkedHashMap<>();
        end.put("endDate", endDate);
        end.put("endTime", endTime);
        this.title = title;
        this.seats = seats;
        this.price = price;
        this.duration = duration;
    }

    public void setStartString(String startString) {
        this.startString = startString;
    }

    public String getEndString() {
        return end.get("endDate") + " " + end.get("endTime");
    }

    public void setEndString(String endString) {
        this.endString = endString;
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

    public String toString() {
        return this.title;
    }

    public Map<String, String> getStart() {
        return start;
    }

    public String getStartString() {
        return start.get("startDate") + " " + start.get("startTime");
    }

    public void setStart(Map<String, String> start) {
        this.start = start;
    }

    public Map<String, String> getEnd() {
        return end;
    }

    public void setEnd(Map<String, String> end) {
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}