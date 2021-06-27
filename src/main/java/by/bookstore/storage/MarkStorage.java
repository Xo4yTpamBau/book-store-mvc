package by.bookstore.storage;

import by.bookstore.entity.Book;
import by.bookstore.entity.Bookmark;

import java.util.List;

public interface MarkStorage {

    Bookmark addBookmark(Bookmark bookmark);

    List<Bookmark> getAll();
}
