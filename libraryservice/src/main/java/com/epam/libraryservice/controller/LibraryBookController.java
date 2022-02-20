package com.epam.libraryservice.controller;

import com.epam.libraryservice.VO.Book;
import com.epam.libraryservice.service.LibraryBookService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/library/books")
public class LibraryBookController {

    private static final String BOOK_SERVICE = "bookService";
    @Autowired
    private LibraryBookService libraryBookService;

    private static Logger logger = LoggerFactory.getLogger(LibraryBookController.class);

    @GetMapping("/")
    @CircuitBreaker(name = BOOK_SERVICE, fallbackMethod = "listOfAllBooksFallback")
    public ResponseEntity<Book[]> listOfAllBooks(){
        return libraryBookService.listOfAllBooks();
    }

    public ResponseEntity<Book[]> listOfAllBooksFallback(Exception e){
        logger.info("listOfAllBooksFallback started");
        ResponseEntity responseEntity = new ResponseEntity<Book[]>(HttpStatus.OK);
        logger.info("listOfAllBooksFallback ending");
        return responseEntity;
    }

    @GetMapping("/{book_id}")
    public ResponseEntity<Book> getBookById(@PathVariable("book_id") int bookId){
        return libraryBookService.getBookById(bookId);
    }

    @PostMapping("/")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        return libraryBookService.saveBook(book);
    }

    @DeleteMapping("/{book_id}")
    public void deleteBook(@PathVariable("book_id") int bookId){
        libraryBookService.deleteBook(bookId);
    }

    @PutMapping("/{book_id}")
    public void updateBook(@PathVariable("book_id") int bookId, @RequestBody Book book){
        libraryBookService.updateBook(bookId, book);
    }
}
