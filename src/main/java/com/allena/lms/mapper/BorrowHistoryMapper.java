package com.allena.lms.mapper;

import com.allena.lms.db.RowMapper;
import com.allena.lms.model.BorrowHistory;
import com.allena.lms.repository.BookRepository;
import com.allena.lms.repository.StudentRepository;

import java.sql.ResultSet;

public class BorrowHistoryMapper implements RowMapper<BorrowHistory> {

    StudentRepository studentRepository = new StudentRepository();
    BookRepository bookRepository = new BookRepository();

    @Override
    public BorrowHistory map(ResultSet resultSet) throws Exception {
        BorrowHistory borrowHistory = new BorrowHistory();
        borrowHistory.setStudent(studentRepository.getStudentById(resultSet.getLong("student_id")));
        borrowHistory.setBook(bookRepository.getById(resultSet.getLong("book_id")));
        borrowHistory.setIssueDate(resultSet.getDate("issue_date"));
        borrowHistory.setReturnDate(resultSet.getDate("return_date"));
        return borrowHistory;
    }
}