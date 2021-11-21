package com.example.crudtest.service;

import com.example.crudtest.domain.Book;
import com.example.crudtest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    // get list
    public List<Book> getBookList(){
        List<Book> books = bookRepository.findAll();
        return books;
    }

    // get one
    public Optional<Book> getBook(Long id){

        Optional<Book> book = bookRepository.findById(id);
        return book;
    }

    // save
    public Book saveBook(Book book){

        return bookRepository.save(book);
    }

    // delete
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

}
