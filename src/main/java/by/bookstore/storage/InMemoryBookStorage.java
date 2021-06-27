package by.bookstore.storage;

import by.bookstore.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryBookStorage implements BookStorage{

    private List<Book> books = new ArrayList<>();
    private static long incId;

    private Book incId (Book book){
        book.setId(incId++);
        return book;
    }

    @Override
    public Book save(Book book) {
        Book book1 = incId(book);
        books.add(book1);
        return book1;
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(books);
    }

    @Override
    public Book getById(long id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
