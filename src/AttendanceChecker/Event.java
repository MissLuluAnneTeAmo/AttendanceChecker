package AttendanceChecker;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String title;
    private String description;
    private String date;
    private String time;
    private final ArrayList<Person> people;

    public Event(String title, String description, String date, String time, ArrayList<Person> people) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
        this.people = people;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return title + " - " + description + " on " + date + " at " + time;
    }
}

