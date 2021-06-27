package by.bookstore.controller;

import by.bookstore.entity.Author;
import by.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/save")
    public String save() {
        return "saveAuthor";
    }

    @PostMapping("/save")
    public String save(Author author) {
        authorService.save(author);
        return "redirect:/";
    }
}
