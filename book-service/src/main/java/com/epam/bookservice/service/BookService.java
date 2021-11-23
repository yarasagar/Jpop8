package com.epam.bookservice.service;

import com.epam.bookservice.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getListOfAllBooks();

    Optional<Book> getBookById(int bookId);

    Book saveBook(Book book);

    void removeBook(int bookId);

    Book updateBook(int bookId, Book book);
}
