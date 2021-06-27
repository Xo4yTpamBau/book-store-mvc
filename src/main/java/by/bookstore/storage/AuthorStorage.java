package by.bookstore.storage;

import by.bookstore.entity.Author;

import java.util.List;

public interface AuthorStorage {

    Author save (Author author);

    Author getById(long id);

    List<Author> getAll();


}
