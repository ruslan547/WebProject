package by.itClass.model.enums;

import by.itClass.constants.SQLRequest;

public enum SectionMenu {
    HOME(SQLRequest.WHERE_HOME),
    TODAY(SQLRequest.WHERE_TODAY),
    TOMORROW(SQLRequest.WHERE_TOMORROW),
    SOON(SQLRequest.WHERE_SOON),
    FINISHED(SQLRequest.WHERE_FINISHED),
    ALL(SQLRequest.WHERE_ALL);

    private String sql;
    private SectionMenu(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return SQLRequest.GET_EVENTS + sql;
    }
}
