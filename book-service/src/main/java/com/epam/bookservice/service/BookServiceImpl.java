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
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent())
            bookRepository.delete(book.get());

    }

    @Override
    public Book updateBook(int bookId, Book book) {
        Optional<Book> book1 = bookRepository.findById(bookId);
        if (!book1.isPresent()){
            return book;
        }
        if(!"".equals(book.getBookName())){
            book1.get().setBookName(book.getBookName());
        }
        return bookRepository.save(book1.get());
    }
}
