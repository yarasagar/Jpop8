package com.epam.bookservice.service;

import com.epam.bookservice.entity.Book;
import com.epam.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getListOfAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(int bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void removeBook(int bookId) {
        Book book = bookRepository.getById(bookId);
        bookRepository.delete(book);
    }

    @Override
    public Book updateBook(int bookId, Book book) {
        Book book1 = bookRepository.getById(bookId);
        if(!"".equals(book.getBookName())){
            book1.setBookName(book.getBookName());
        }
        return bookRepository.save(book1);
    }
}
