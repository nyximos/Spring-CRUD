package com.example.crudtest.controller;

import com.example.crudtest.domain.Book;
import com.example.crudtest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookAjaxApiController {

    @Autowired
    BookService bookService;


    @PostMapping("/ajax")
    public Book post(@RequestBody Book book){
        return bookService.saveBook(book);
    }

}
