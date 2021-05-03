package by.itClass.constants;

public final class SQLRequest {
    public static final String SAVE_USER =
            "insert into users(login, password, name, surname, age, email) values(?,?,?,?,?,?)";
    public static final String FOUND_LOGIN =
            "select id from users where login=?";
}
