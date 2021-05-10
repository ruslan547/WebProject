package by.itClass.model.enums;

import by.itClass.constants.SQLRequest;

public enum SectionMenu {
    HOME(SQLRequest.WHERE_TODAY),
    TODAY(SQLRequest.WHERE_TOMORROW),
    TOMORROW(SQLRequest.WHERE_SOON),
    SOON(SQLRequest.WHERE_FINISHED),
    FINISHED(SQLRequest.WHERE_ALL),
    ALL(SQLRequest.WHERE_HOME);

    private String sql;
    private SectionMenu(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return SQLRequest.GET_EVENTS + sql;
    }
}
