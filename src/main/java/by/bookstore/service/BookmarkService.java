package by.bookstore.service;

import by.bookstore.entity.Bookmark;
import by.bookstore.storage.InMemoryMarkStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookmarkService {

    @Autowired
    private InMemoryMarkStorage inMemoryMarkStorage;

    public Bookmark addBookmark(Bookmark bookmark){
        return inMemoryMarkStorage.addBookmark(bookmark);
    }

    public List<Bookmark> getAll(){
        return inMemoryMarkStorage.getAll();
    }
}
