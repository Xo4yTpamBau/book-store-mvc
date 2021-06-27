package by.bookstore.controller;

import by.bookstore.entity.*;
import by.bookstore.service.AuthorService;
import by.bookstore.service.BookService;
import by.bookstore.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookmarkService bookmarkService;

    @GetMapping("/save")
    public String save(Model model) {
        List<Author> all = authorService.getAll();
        model.addAttribute("authors", all);
        return "saveBook";
    }

    @PostMapping("/save")
    public String save(Book book) {
        bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/soloBook")
    public String soloBook(Model model, long id) {
        Book byId = bookService.getById(id);
        model.addAttribute("book", byId);
        return "soloBook";
    }

    @PostMapping("/createComment")
    public String createComment(Book book, Comment comment, HttpSession httpSession) {
        comment.setUser((User) httpSession.getAttribute("user"));
        Book byId = bookService.getById(book.getId());
        List<Comment> comments = byId.getComments();
        comments.add(comment);
        return "redirect:/book/soloBook?id=" + book.getId();
    }

    @PostMapping("/likeBook")
    public String likeBook(int bookId, HttpSession httpSession){
        Like like = new Like();
        Book book = bookService.getById(bookId);
        User user = (User) httpSession.getAttribute("user");
        List<Like> likes = book.getLikes();
        like.setUser(user);
        like.setBook(book);
        likes.add(like);
        return "redirect:/book/soloBook?id=" + bookId;
    }

    @PostMapping("/bookmark")
    public String addBookmark(long bookId, HttpSession httpSession){
        Book book = bookService.getById(bookId);
        User user = (User) httpSession.getAttribute("user");
        Bookmark bookmark = new Bookmark();
        bookmark.setUser(user);
        bookmark.setBook(book);
        bookmarkService.addBookmark(bookmark);
        return "redirect:/book/soloBook?id=" + bookId;
    }

    @GetMapping("/allbookmark")
    public String allBookmark(Model model){
        List<Bookmark> all = bookmarkService.getAll();
        model.addAttribute("allBookmark", all);
        return "allBookmark";
    }

}
