package com.bookshop.catalogservice.domain;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> viewBookList() {
        return bookRepository.findAll();
    }


    public Book viewBookDetail(String isbn) {
        return this.bookRepository.findByIsbn(isbn)
                .orElseThrow(()->new BookNotFoundException(isbn));
    }



    public boolean existByIsbn(String isbn) {
        return bookRepository.existByIsbn(isbn);
    }


    public Book save(Book book) {
        return null;
    }


    public void deleteByIsbn(String isbn) {
        bookRepository.deleteByIsbn(isbn);
    }
    public Book addBookToCategory(Book book){
        if (bookRepository.existByIsbn(book.isbn())){
            throw new BookAlreadyExistException(book.isbn());
        }
        return bookRepository.save(book);
    }

    public Book editBookDetailsById(String isbn, Book book){
        return bookRepository.findByIsbn(isbn).map((b)->{
        var bookUpdate=new Book(b.isbn(),b.title(),b.author(),b.price());
        return bookRepository.save(bookUpdate);
        }).orElseGet(()->addBookToCategory(book));
    }

}
