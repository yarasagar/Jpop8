package com.epam.libraryservice.controller;

import com.epam.libraryservice.VO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @PostMapping("/users/{user_id}/books/{book_id}")
    public void issueBookToUser(){

    }

    @DeleteMapping("/users/{user_id}/books/{book_id}")
    public void releaseBookFromUser(){

    }

}
