package by.bookstore.storage;

import by.bookstore.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryUserStorage implements UserStorage{

    private static long incId;
    private static List<User> users = new ArrayList<>();

    private User incId(User user){
        user.setId(incId++);
        return user;
    }
    @Override
    public User save(User user) {
        User user1 = incId(user);
        users.add(user1);
        return user1;
    }

    @Override
    public User getById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}
