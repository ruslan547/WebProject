package by.itClass.model.services;

import by.itClass.model.beans.User;

public interface UserService {
    boolean save(User user, String password);
}
