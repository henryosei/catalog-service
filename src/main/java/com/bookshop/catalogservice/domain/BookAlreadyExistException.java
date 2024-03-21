package com.bookshop.catalogservice.domain;

public class BookAlreadyExistException extends RuntimeException{

    public BookAlreadyExistException(String isbn) {
        super("A book with isbn (%s) already exist".formatted(isbn));
    }
}
