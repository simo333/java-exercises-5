package com.example.javaexercises5.lambda.Test;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {
    private int pages;
    private String title;

    public Book(int pages, String title) {
        this.pages = pages;
        this.title = title;
    }
}
