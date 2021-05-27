package by.itClass.model.beans;

import by.itClass.constants.Constant;
import by.itClass.model.exceptions.ServiceException;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private int id;
    private String title;
    private String descr;
    private String place;
    private Date date;
    private String author;
    private List<Program> programs;

    public Event() {
        programs = new ArrayList<>();
    }

    public Event(String title, String descr, String place, String date) throws ServiceException {
        this();
        this.title = title;
        this.descr = descr;
        this.place = place;
        setDate(date);

    }

    public Event(int id, String title, String descr, String place, Date date, String author) {
        this();
        this.id = id;
        this.title = title;
        this.descr = descr;
        this.place = place;
        this.date = date;
        this.author = author;
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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate(String date) throws ServiceException {
        SimpleDateFormat formatter = new SimpleDateFormat(Constant.DATE_PATTERN);
        try {
            this.date = new Date(formatter.parse(date).getTime()); //lang.Date->sqlDate
        } catch (ParseException e) {
            throw new ServiceException(e);
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    public void addPrograms(String[] titles, String[] times) throws ServiceException {
        int length = Integer.min(titles.length, times.length);
        for (int i = 0; i < length; i++) {
            programs.add(new Program(titles[i], times[i]));
        }

        this.programs = programs;
    }
}
