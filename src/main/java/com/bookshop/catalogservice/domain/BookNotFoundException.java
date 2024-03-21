package com.bookshop.catalogservice.domain;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String isbn) {
        super("A book with isbn (%s) not found".formatted(isbn));
    }
}
