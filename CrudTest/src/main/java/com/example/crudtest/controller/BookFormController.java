package com.example.crudtest.controller;

import com.example.crudtest.domain.Book;
import com.example.crudtest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class BookFormController {

    @Autowired
    BookService bookService;

    // 조회
    @GetMapping("/")
    public String getIndex(Model model){

        List<Book> books = bookService.getBookList();
        model.addAttribute("books", books);

        return "index";
    }

    // 상세조회
   @GetMapping("/{id}")
    public String getIndex(Model model,
                           @PathVariable Long id){

        Optional<Book> book = bookService.getBook(id);
        model.addAttribute("book", book);

        return "index";
    }


    // 등록
    @PostMapping("/")
    public String postBook(@RequestParam String author,
                         @RequestParam String title,
                         @RequestParam String content,
                           Model model) {

        Book book = new Book(author, title, content);
        bookService.saveBook(book);

        List<Book> books = bookService.getBookList();
        model.addAttribute("books", books);
        return "index";
    }

    // 삭제
    @PostMapping("/{id}")
    public String deleteBook(Model model, @PathVariable Long id) {

        bookService.deleteBook(id);

        List<Book> books = bookService.getBookList();
        model.addAttribute("books", books);
        return "index";
    }

    // 수정
    @PostMapping("/{id}")
    public String updateBook(Model model,
                             @RequestParam String author,
                             @RequestParam String title,
                             @RequestParam String content,
                             @PathVariable Long id){

        Optional<Book> book = bookService.getBook(id);


        List<Book> books = bookService.getBookList();
        model.addAttribute("books", books);
        return "index";
    }

}
