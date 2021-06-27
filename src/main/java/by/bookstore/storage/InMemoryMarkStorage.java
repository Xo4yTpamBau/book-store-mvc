package by.bookstore.storage;

import by.bookstore.entity.Book;
import by.bookstore.entity.Bookmark;
import by.bookstore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class InMemoryMarkStorage implements MarkStorage{


    private List<Bookmark> bookmarks = new ArrayList<>();
    private long incId;

    private Bookmark incId(Bookmark bookmark){
        bookmark.setId(incId++);
        return bookmark;
    }
    @Override
    public Bookmark addBookmark(Bookmark bookmark) {
        Bookmark bookmark1 = incId(bookmark);
        bookmarks.add(bookmark1);
        return bookmark1;
    }

    @Override
    public List<Bookmark> getAll() {
        return new ArrayList<>(bookmarks);
    }
}
