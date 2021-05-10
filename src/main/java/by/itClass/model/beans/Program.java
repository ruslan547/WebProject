package by.itClass.model.beans;

import java.sql.Time;

public class Program {
    private int id;
    private String title;
    private Time time;

    public Program() {
    }

    public Program(int id, String title, Time time) {
        this.id = id;
        this.title = title;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
