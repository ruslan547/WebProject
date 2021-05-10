package by.itClass.constants;

public final class SQLRequest {
    public static final String SAVE_USER =
            "insert into users(login, password, name, surname, age, email) values(?,?,?,?,?,?)";
    public static final String FOUND_LOGIN =
            "select id from users where login=?";
    public static final String GET_USER =
            "select * from users where login=? and password=?";

    public static final String GET_EVENTS = "select " +
            "events.id," +
            "events.title," +
            "events.desc," +
            "events.place," +
            "events.date," +
            "concat_ws(users.name,users.surname) as author" +
            " from events " +
            "join users on events.idUser = users.id ";
    public static final String WHERE_TODAY = "where date=curdate()";
    public static final String WHERE_TOMORROW = "";
    public static final String WHERE_SOON = "";
    public static final String WHERE_FINISHED = "";
    public static final String WHERE_ALL = "";
    public static final String WHERE_HOME = "";

}
