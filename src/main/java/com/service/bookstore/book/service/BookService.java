package com.service.bookstore.book.service;

import com.service.bookstore.book.model.Book;
import com.service.bookstore.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String addBook(Book book) {
        if (bookRepository.findByTitle(book.getTitle()) != null) {
            return "The book already exists";
        }
        bookRepository.save(book);
        return "Added Successfully";
    }

    public void deleteByTitle(String title) {
        bookRepository.deleteByTitle(title);
    }

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public List<Book> findByAuthor (String author) {
        return bookRepository.findByAuthor(author);
    }

    public String updatePrice (String title, Double price) {
        Book book = bookRepository.findByTitle(title);
        if (book != null) {
            book.setPrice(price);
            bookRepository.save(book);
            return "The price has been successfully updated";
        } else {
            return "Book doesn't exist";
        }
    }
}
