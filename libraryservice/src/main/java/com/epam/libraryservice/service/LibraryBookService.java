package com.epam.libraryservice.service;

import com.epam.libraryservice.VO.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LibraryBookService {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<Book[]> listOfAllBooks() {
        return restTemplate.getForEntity("http://BOOK-SERVICE/api/books/", Book[].class);
    }

    public ResponseEntity<Book> getBookById(int bookId) {
        return restTemplate.getForEntity("http://BOOK-SERVICE/api/books/"+bookId, Book.class);
//        return restTemplate.getForEntity("http://localhost:9002/api/books/"+bookId, Book.class);
    }

    public ResponseEntity<Book> saveBook(Book book) {
        return restTemplate.postForEntity("http://BOOK-SERVICE/api/books/", book, Book.class);
//        return restTemplate.postForEntity("http://localhost:9002/api/books/", book, Book.class);
    }

    public void deleteBook(int bookId) {
        restTemplate.delete("http://BOOK-SERVICE/api/books/"+bookId);
//        restTemplate.delete("http://localhost:9002/api/books/"+bookId);
    }

    public void updateBook(int bookId, Book book) {
        restTemplate.put("http://BOOK-SERVICE/api/books/"+bookId, book);
//        restTemplate.put("http://localhost:9002/api/books/"+bookId, book);
    }
}
