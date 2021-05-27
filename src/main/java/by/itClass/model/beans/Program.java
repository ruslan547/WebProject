package by.itClass.model.beans;

import by.itClass.constants.Constant;
import by.itClass.model.exceptions.ServiceException;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;

public class Program {
    private int id;
    private String title;
    private Time time;

    public Program() {
    }

    public Program(String title, String time) throws ServiceException {
        this.title = title;
        setTime(time);
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

    public void setTime(String time) throws ServiceException {
        SimpleDateFormat format = new SimpleDateFormat(Constant.TIME_PATTERN);
        try {
            this.time = new Time(format.parse(time).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }
    }
}
