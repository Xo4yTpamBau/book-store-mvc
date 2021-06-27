package by.bookstore.storage;

import by.bookstore.entity.Book;

import java.util.List;

public interface BookStorage {

    Book save (Book book);

    List<Book> getAll ();

    Book getById (long id);
}
