package com.allena.lms.repository;

import com.allena.lms.db.JdbcTemplate;
import com.allena.lms.mapper.BookMapper;
import com.allena.lms.model.Book;

import java.util.List;

public class BookRepository {

    private final JdbcTemplate<Book> bookJdbcTemplate = new JdbcTemplate<>();

    public List<Book> getAll() throws Exception {
        return bookJdbcTemplate
                .getAll(
                        "SELECT * FROM TBL_BOOKS",
                        new BookMapper()
                );
    }

    public Book getById(Long id) throws Exception {
        return bookJdbcTemplate
                .getByObject(
                        "SELECT * FROM TBL_BOOKS WHERE id=?",
                        new Object[]{id},
                        new BookMapper()
                );
    }

    public void create(Book book) throws Exception {
        bookJdbcTemplate
                .update(
                        "INSERT INTO TBL_BOOKS (id,name,isbn,edition,price,pages) VALUES (?,?,?,?,?,?)",
                        new Object[]{book.getId(), book.getName(), book.getIsbn(), book.getEdition(), book.getPrice(), book.getPages()}
                );
    }

}