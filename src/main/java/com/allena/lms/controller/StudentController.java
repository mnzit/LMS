package com.allena.lms.controller;

import com.allena.lms.model.Student;
import com.allena.lms.repository.StudentRepository;

public class StudentController {
    StudentRepository studentRepository = new StudentRepository();

    public void addStudent(Student student) {
        try {
           studentRepository.create(student);
            System.out.println(student.getName() + " ADDED SUCCESSFULLY!");
        } catch (Exception e) {
            System.err.println("ADD_STUDENT_EXCEPTION: " + e.getMessage());
        }
    }

}
