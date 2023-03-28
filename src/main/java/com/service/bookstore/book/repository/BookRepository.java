package com.service.bookstore.book.repository;

import com.service.bookstore.book.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    Book findByTitle(String title);

    void deleteByTitle(String title);
}


