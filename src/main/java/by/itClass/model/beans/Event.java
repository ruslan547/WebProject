package by.itClass.model.beans;

import by.itClass.constants.Constant;
import by.itClass.model.exceptions.ServiceException;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Event {
    private int id;
    private int idUser;
    private String title;
    private String desc;
    private String place;
    private Date date;
    private String author; //Name Surname
    private List<Program> programs;

    public Event() {
    }

    public Event(String title, String desc, String place, String date) throws ServiceException {
        this.title = title;
        this.desc = desc;
        this.place = place;
        setDate(date);
    }

    public Event(int id, String title, String desc, String place, Date date, String author) {
        this.id = id;
        this.title = title;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
            this.date = new Date(formatter.parse(date).getTime());
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
}
