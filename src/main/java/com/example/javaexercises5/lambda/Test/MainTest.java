package com.example.javaexercises5.lambda.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainTest {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book(100, "bbb"),
                new Book(200, "aaa")
        );

//        books.sort((b1, b2) -> b1.getPages() - b2.getPages());
        books.sort(Comparator.comparingInt(Book::getPages));
        System.out.println(books);
//        books.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
        books.sort(Comparator.comparing(Book::getTitle));
        System.out.println(books);

        System.out.println();

        List<Book> newBooks = books
                .stream()
                .filter(book -> book.getPages() > 100)
                .peek(book -> book.setTitle("Nowy tytuł"))
                .collect(Collectors.toList());
        System.out.println(newBooks);
    }
}
