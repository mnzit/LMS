package com.allena.lms.controller;

import com.allena.lms.model.Book;
import com.allena.lms.repository.BookRepository;

import java.util.List;

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

    public void listBooks(){
        try {
            List<Book> books = bookRepository.getAll();
            for(Book book: books){
                System.out.println(book);
            }
        } catch (Exception e) {
            System.err.println("LIST_BOOKS_EXCEPTION: " + e.getMessage());
        }
    }

}
