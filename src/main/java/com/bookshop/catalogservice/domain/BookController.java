package com.bookshop.catalogservice.domain;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<Book> get() {
        return this.bookService.viewBookList();
    }

    @GetMapping("{isdn}")
    public Book getByIsdn(@PathVariable("isdn") String isdn) {
        return bookService.viewBookDetail(isdn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book post(@Valid @RequestBody Book book) {
        return bookService.save(book);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{isbn}")
    public void deleteBook(@PathVariable("isbn") String isbn) {
        bookService.deleteByIsbn(isbn);
    }

    @PutMapping("{isbn}")
    public Book put(@PathVariable("isbn") String isbn, @Valid @RequestBody Book book) {
        return bookService.editBookDetailsById(isbn, book);
    }
}
