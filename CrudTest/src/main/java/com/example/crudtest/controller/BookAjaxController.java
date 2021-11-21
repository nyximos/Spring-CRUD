package com.example.crudtest.controller;

import com.example.crudtest.domain.Book;
import com.example.crudtest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BookAjaxController {

    @Autowired
    BookService bookService;

    @GetMapping("/ajax")
    public String getAjax(Model model){

        List<Book> books = bookService.getBookList();
        model.addAttribute("books", books);

        return "ajax";
    }

}
