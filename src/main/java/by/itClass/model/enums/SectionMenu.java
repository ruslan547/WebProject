package by.itClass.model.enums;

import by.itClass.constants.SQLRequest;

public enum SectionMenu {
    TODAY(SQLRequest.WHERE_TODAY),
    TOMORROW(SQLRequest.WHERE_TOMORROW),
    SOON(SQLRequest.WHERE_SOON),
    FINISHED(SQLRequest.WHERE_FINISHED),
    ALL(SQLRequest.WHERE_ALL),
    HOME(SQLRequest.WHERE_HOME),
    BY_ID(SQLRequest.WHERE_BY_ID);

    private String sql;

    private SectionMenu(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return SQLRequest.GET_EVENTS + sql;
    }
}
