package by.bookstore.service;

import by.bookstore.entity.Book;
import by.bookstore.storage.InMemoryBookStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {

    @Autowired
    private InMemoryBookStorage inMemoryBookStorage;

    public Book save(Book book){
        return inMemoryBookStorage.save(book);
    }

    public List<Book> getAll(){
        return inMemoryBookStorage.getAll();
    }

    public Book getById(long id){
        return inMemoryBookStorage.getById(id);
    }
}
