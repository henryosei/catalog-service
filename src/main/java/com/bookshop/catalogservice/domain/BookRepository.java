package com.bookshop.catalogservice.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository  extends CrudRepository<Book,Long> {

    Iterable<Book> findAll();

    Optional<Book> findByIsbn(String isbn);

    boolean existByIsbn(String isbn);

    Book save(Book book);
    void deleteByIsbn(String isbn);
}
