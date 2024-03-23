package com.bookshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.*;

import java.time.Instant;

public record Book(
        @Id
        Long id,
        @NotBlank(message = "The book ISBN must be define")
        String isbn,
        @NotBlank(message = "The book title must be defined")
        String title,
        @NotBlank(message = "The book author must be defined")
        String author,

        @NotNull(message = "The book price must be define")
        @Positive(message = "the book price must be greater than zero")
        Double price,
        @Version
        int version,
        @CreatedDate
        Instant createdDate,
        @LastModifiedDate
        Instant lastModifiedDate,
        String publisher

) {
    public static Book of(
            String isbn, String title, String author, Double price, String publisher
    ) {
        return new Book(
                null,
                isbn,
                title,
                author,
                price,
                0,
                null,
                null,
                publisher
        );
    }
}
