package by.bookstore.service;

import by.bookstore.entity.Author;
import by.bookstore.storage.AuthorStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorService {

    @Autowired
    private AuthorStorage authorStorage;

    public Author save (Author author){
        return authorStorage.save(author);
    }

    public Author getById(long id){
        return authorStorage.getById(id);
    }

    public List<Author> getAll(){
        return authorStorage.getAll();
    }

}
