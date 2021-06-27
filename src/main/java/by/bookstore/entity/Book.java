package by.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

    private long id;
    private String title;
    private Author author;
    private String description;
    private double price;
    private List<Comment> comments = new ArrayList<>();
    private List<Like> likes = new ArrayList<>();
}
