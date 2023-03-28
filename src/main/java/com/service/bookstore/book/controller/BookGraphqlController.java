package com.service.bookstore.book.controller;

import com.service.bookstore.book.model.Book;
import com.service.bookstore.book.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookGraphqlController {

    final BookService bookService;

    public BookGraphqlController(BookService bookService) {
        this.bookService = bookService;
    }

    @MutationMapping
    public String addBook(@Argument Book book) {
        return bookService.addBook(book);
    }

    @MutationMapping
    public void deleteByTitle(@Argument String title) { bookService.deleteByTitle(title); }

    @MutationMapping
    public String updatePrice(@Argument String title, @Argument Double price) { return bookService.updatePrice(title, price);}

    @QueryMapping
    public List<Book> allBooks() { return bookService.allBooks(); }

    @QueryMapping
    public  List<Book> findByAuthor(@Argument String author) { return bookService.findByAuthor(author); }

}
