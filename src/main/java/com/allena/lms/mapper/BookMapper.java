package com.allena.lms.mapper;

import com.allena.lms.db.RowMapper;
import com.allena.lms.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book map(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setName(resultSet.getString("name"));
        book.setIsbn(resultSet.getInt("isbn"));
        book.setEdition(resultSet.getInt("edition"));
        book.setPrice(resultSet.getDouble("price"));
        book.setPages(resultSet.getInt("pages"));
        return book;
    }
}
