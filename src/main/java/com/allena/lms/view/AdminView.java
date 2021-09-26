package com.allena.lms.view;

import com.allena.lms.controller.AdminController;
import com.allena.lms.controller.BookController;
import com.allena.lms.controller.BorrowHistoryController;
import com.allena.lms.controller.StudentController;
import com.allena.lms.dto.BorrowHistoryDTO;
import com.allena.lms.dto.LoginDTO;
import com.allena.lms.model.Admin;
import com.allena.lms.model.Book;
import com.allena.lms.model.Student;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AdminView {

    private Admin currentAdmin;

    public Admin getCurrentAdmin() {
        return currentAdmin;
    }

    private final AdminController adminController = new AdminController();
    private final BookController bookController = new BookController();
    private final BorrowHistoryController borrowHistoryController = new BorrowHistoryController();
    private final StudentController studentController = new StudentController();


    public void login() {
        System.out.println("Welcome to LMS. Login to use the application");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println("");
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        System.out.println("");

        currentAdmin = adminController.login(new LoginDTO(email, password));

        if (currentAdmin == null) {
            System.out.println("Incorrect email/password!");
        } else {
            System.out.println("Welcome, " + currentAdmin.getName());
        }
    }

    public void addBook() {
        System.out.println("Enter the book details");

        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.print("Enter Book Name: ");
        book.setName(scanner.nextLine());
        System.out.println("");
        System.out.print("Enter Book ISBN: ");
        book.setIsbn(scanner.nextInt());
        System.out.println("");
        System.out.print("Enter Book Edition: ");
        book.setEdition(scanner.nextInt());
        System.out.println("");
        System.out.print("Enter Book Price: ");
        book.setPrice(scanner.nextDouble());
        System.out.println("");
        System.out.print("Enter Book Pages: ");
        book.setPages(scanner.nextInt());
        System.out.println("");
        bookController.addBook(book);
    }

    public void addStudent() {
        System.out.println("Enter the student details");

        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        System.out.print("Enter Student Name: ");
        student.setName(scanner.nextLine());
        System.out.println("");
        System.out.print("Enter Student Course: ");
        student.setCourse(scanner.nextLine());
        System.out.println("");
        System.out.print("Enter Student Branch: ");
        student.setBranch(scanner.nextLine());
        System.out.println("");
        System.out.print("Enter Student Join Year: ");
        student.setYear(scanner.nextInt());
        System.out.println("");
        System.out.print("Enter Student Semester: ");
        student.setSemester(scanner.nextInt());
        System.out.println("");
        studentController.addStudent(student);
    }

    public void borrowBook() {
        System.out.println("Enter Borrowing Details");
        BorrowHistoryDTO borrowHistoryDTO = new BorrowHistoryDTO();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student Id: ");
        borrowHistoryDTO.setStudentId(scanner.nextLong());
        System.out.println("");
        System.out.print("Enter Book Id: ");
        borrowHistoryDTO.setBookId(scanner.nextLong());
        System.out.println("");
        if (borrowHistoryController.borrowBook(borrowHistoryDTO)) {
            System.out.println("SUCCESSFULLY BORROWED");
        } else {
            System.out.println("FAILED BORROWING");
        }
    }

    public void returnBook() {
        try {
            System.out.println("Whats Returning Details");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter Book Id: ");
            Long bookId = scanner.nextLong();
            System.out.println("");
            System.out.print("Enter Student Id: ");
            Long studentId = scanner.nextLong();
            System.out.println("");
            BorrowHistoryDTO borrowHistoryDTO = new BorrowHistoryDTO();

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            borrowHistoryDTO.setReturnDate(dateFormat.format(date));
            borrowHistoryDTO.setBookId(bookId);
            borrowHistoryDTO.setStudentId(studentId);
            if (borrowHistoryController.returnBook(borrowHistoryDTO)) {
                System.out.println("SUCCESSFULLY RETURNED");
            } else {
                System.out.println("FAILED RETURNING");
            }


        } catch (Exception e) {
            System.err.println("RETURN_EXCEPTION: " + e.getMessage());
        }
    }

    public void listBooks(){
        bookController.listBooks();
    }

    public void listStudents(){
        studentController.listStudents();
    }

    public void init(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            if(currentAdmin == null) {
                System.out.println("Library Management System Started...");

                System.out.println("Press [L] to Login & Press [Q] to quit");
                String condition = scanner.nextLine();
                switch (condition){
                    case "L":
                        login();
                        break;
                    case "Q":
                        System.out.println("Library Management System Closed...");
                        System.exit(0);
                }
            }else{
                System.out.println("Press the specific code to proceed");
                System.out.println("[1] ADD BOOK");
                System.out.println("[2] BORROW BOOK");
                System.out.println("[3] RETURN BOOK");
                System.out.println("[4] ADD STUDENT");
                System.out.println("[5] LIST STUDENTS");
                System.out.println("[6] LIST BOOKS");
                System.out.println("[Q] QUIT");
                String condition = scanner.nextLine();
                switch (condition){
                    case "1":
                        addBook();
                        break;
                    case "2":
                        borrowBook();
                        break;
                    case "3":
                        returnBook();
                        break;
                    case "4":
                        addStudent();
                        break;
                    case "5":
                        listStudents();
                        break;
                    case "6":
                        listBooks();
                        break;
                    case "Q":
                        System.out.println("Library Management System Closed...");
                        System.exit(0);
                }
            }
        }
    }
}
