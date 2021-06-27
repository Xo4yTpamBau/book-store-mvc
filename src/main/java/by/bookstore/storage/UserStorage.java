package by.bookstore.storage;

import by.bookstore.entity.User;

public interface UserStorage {

    User save (User user);

    User getById(long id);

    User getByLogin(String login);
}
