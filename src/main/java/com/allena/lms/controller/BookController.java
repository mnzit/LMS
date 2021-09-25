package com.allena.lms.controller;

import com.allena.lms.model.Book;
import com.allena.lms.repository.BookRepository;

public class BookController {
    BookRepository bookRepository = new BookRepository();

    public void addBook(Book book) {
        try {
            bookRepository.create(book);
            System.out.println(book.getName() + " ADDED SUCCESSFULLY!");
        } catch (Exception e) {
            System.err.println("ADD_BOOK_EXCEPTION: " + e.getMessage());
        }
    }

}
