package com.allena.lms.repository;

import com.allena.lms.db.JdbcTemplate;
import com.allena.lms.db.RowMapper;
import com.allena.lms.dto.BorrowHistoryDTO;
import com.allena.lms.mapper.BorrowHistoryMapper;
import com.allena.lms.model.BorrowHistory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class BorrowHistoryRepository {

    private final JdbcTemplate<BorrowHistory> borrowHistoryJdbcTemplate = new JdbcTemplate<>();

    public boolean borrowBook(BorrowHistoryDTO borrowHistory) throws Exception {
       return borrowHistoryJdbcTemplate.update("INSERT INTO TBL_BORROW_HISTORY (id,student_id,book_id,issue_date) VALUES (?,?,?,?)", new Object[]{borrowHistory.getId(),borrowHistory.getStudentId(),borrowHistory.getBookId(),borrowHistory.getIssueDate()}) > 0;
    }

    public boolean returnBook(BorrowHistoryDTO borrowHistoryDTO) throws Exception {
        return borrowHistoryJdbcTemplate.update("UPDATE TBL_BORROW_HISTORY SET return_date=? WHERE book_id=? AND student_id=? AND return_date IS NULL", new Object[]{borrowHistoryDTO.getReturnDate(),borrowHistoryDTO.getBookId(), borrowHistoryDTO.getStudentId()}) > 0;
    }
}