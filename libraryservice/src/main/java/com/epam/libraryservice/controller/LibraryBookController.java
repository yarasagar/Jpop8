package com.epam.libraryservice.controller;

import com.epam.libraryservice.VO.Book;
import com.epam.libraryservice.service.LibraryBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/library/books")
public class LibraryBookController {

    @Autowired
    private LibraryBookService libraryBookService;

    @GetMapping("/")
    public ResponseEntity<Book[]> listOfAllBooks(){
        return libraryBookService.listOfAllBooks();
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
