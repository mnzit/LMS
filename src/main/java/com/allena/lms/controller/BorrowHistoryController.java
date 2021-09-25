package com.allena.lms.controller;

import com.allena.lms.dto.BorrowHistoryDTO;
import com.allena.lms.repository.BorrowHistoryRepository;

import java.util.Date;

public class BorrowHistoryController {

    BorrowHistoryRepository borrowHistoryRepository = new BorrowHistoryRepository();

    public boolean borrowBook(BorrowHistoryDTO borrow) {
        try {
            borrow.setIssueDate(new Date());
            return borrowHistoryRepository.borrowBook(borrow);
        } catch (Exception e) {
            System.err.println("BORROW_EXCEPTION: " + e.getMessage());
            return false;
        }
    }

    public boolean returnBook(BorrowHistoryDTO borrow) {
        try {
            return borrowHistoryRepository.returnBook(borrow);
        } catch (Exception e) {
            System.err.println("RETURN_EXCEPTION: " + e.getMessage());
            return false;
        }
    }
}
