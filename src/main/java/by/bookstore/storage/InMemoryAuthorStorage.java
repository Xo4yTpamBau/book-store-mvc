package by.bookstore.storage;

import by.bookstore.entity.Author;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryAuthorStorage implements  AuthorStorage {

    private List<Author> authors = new ArrayList<>();
    private static long incId;

    private Author incId(Author author){
        author.setId(incId++);
        return author;
    }

    public Author save (Author author){
        Author author1 = incId(author);
        authors.add(author);
        return author1;
    }

    @Override
    public Author getById(long id) {
        for (Author author : authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    @Override
    public List<Author> getAll() {
        return new ArrayList<>(authors);
    }


}
