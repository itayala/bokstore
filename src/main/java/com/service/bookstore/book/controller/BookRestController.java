package com.service.bookstore.book.controller;

import com.service.bookstore.book.model.Book;
import com.service.bookstore.book.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookRestController {

    final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PostMapping("/deleteByTitle/{title}")
    public void deleteByTitle(@PathVariable String title) { bookService.deleteByTitle(title); }

    @PostMapping("/updatePrice")
    public void updatePrice(@RequestParam String title, @RequestParam Double price) { bookService.updatePrice(title, price); }

    @GetMapping("/allBooks")
    public List<Book> allBooks(){
        return bookService.allBooks();
    }

    @GetMapping("/findByAuthor/{author}")
    public List<Book> findByAuthor(@PathVariable String author) { return bookService.findByAuthor(author); }

}
