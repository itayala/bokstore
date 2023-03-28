package com.service.bookstore.book.model;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("book")
public class Book {

    @Id
    private String id;

    @NotNull
    private final String title;

    @NotNull
    private final String author;

    @NotNull
    private Double price;


    public Book(String title, String author, Double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getId() { return id; }

    public String getTitle() {
        return title;
    }

    public String getAuthor() { return author; }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
