package com.allena.lms;

import com.allena.lms.view.AdminView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AdminView adminView = new AdminView();

        Scanner scanner = new Scanner(System.in);
        while (true){
            if(adminView.getCurrentAdmin() == null) {
                System.out.println("Library Management System Started...");

                System.out.println("Press [L] to Login & Press [Q] to quit");
                String condition = scanner.nextLine();
                switch (condition){
                    case "L":
                        adminView.login();
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
                        adminView.addBook();
                        break;
                    case "2":
                        adminView.borrowBook();
                        break;
                    case "3":
                        adminView.returnBook();
                        break;
                    case "4":
                        adminView.addStudent();
                        break;
                    case "5":
                        adminView.listStudents();
                        break;
                    case "6":
                        adminView.listBooks();
                        break;
                    case "Q":
                        System.out.println("Library Management System Closed...");
                        System.exit(0);
                }
            }
        }
    }
}
