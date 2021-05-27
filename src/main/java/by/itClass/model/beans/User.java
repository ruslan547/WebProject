package by.itClass.model.beans;

import by.itClass.constants.Messages;
import by.itClass.model.exceptions.ServiceException;

public class User {
    private int id;
    private String login;
    private String name;
    private String surname;
    private int age;
    private String email;

    public User() {
    }

    public User(String login, String name, String surname, String age, String email) throws ServiceException {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.email = email;
        setAge(age);
    }

    public User(int id, String login, String name, String surname, int age, String email) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAge(String age) throws ServiceException {
        try {
            this.age = Integer.parseInt(age);
        } catch (NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
