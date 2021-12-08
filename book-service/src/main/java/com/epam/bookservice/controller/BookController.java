package com.epam.bookservice.controller;

import com.epam.bookservice.entity.Book;
import com.epam.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> getListOfAllBooks(){
        return bookService.getListOfAllBooks();
    }

    @GetMapping("/{book_id}")
    public Optional<Book> getBookById(@PathVariable("book_id") int bookId){
        return bookService.getBookById(bookId);
    }

    @PostMapping("/")
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{book_id}")
    public void removeBook(@PathVariable("book_id") int bookId){
        bookService.removeBook(bookId);
    }

    @PutMapping("/{book_id}")
    public Book updateBook(@PathVariable("book_id") int bookId, @RequestBody Book book){
        return bookService.updateBook(bookId, book);
    }

}
