package com.example.crudtest.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String title;
    private String content;

    public Book(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

}
