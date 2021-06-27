package by.bookstore.controller;


import by.bookstore.entity.Author;
import by.bookstore.entity.Book;
import by.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String home (Model model){
        model.addAttribute("books", bookService.getAll());
        return "home";
    }
}
