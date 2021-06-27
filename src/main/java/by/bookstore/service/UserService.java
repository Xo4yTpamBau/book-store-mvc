package by.bookstore.service;

import by.bookstore.entity.User;
import by.bookstore.storage.InMemoryUserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private InMemoryUserStorage inMemoryUserStorage;

    public User save(User user){
     return inMemoryUserStorage.save(user);
    }

    public User getById(long id){
        return inMemoryUserStorage.getById(id);
    }
    public User getByLogin(String login){
        return inMemoryUserStorage.getByLogin(login);
    }

}
