package com.allena.lms.repository;

import com.allena.lms.db.JdbcTemplate;
import com.allena.lms.mapper.StudentMapper;
import com.allena.lms.model.Student;

public class StudentRepository {

    private final JdbcTemplate<Student> studentJdbcTemplate = new JdbcTemplate<>();

    public Student getStudentById(Long id) throws Exception {
        return studentJdbcTemplate
                .getByObject(
                "SELECT * FROM TBL_STUDENTS WHERE id=?",
                new Object[]{id},
                new StudentMapper()
        );
    }

    public void create(Student student) throws Exception {
        studentJdbcTemplate.update(
                "INSERT INTO TBL_STUDENTS (id,name,course,branch,year,semester) VALUES (?,?,?,?,?,?)",
                new Object[]{student.getId(), student.getName(), student.getCourse(), student.getBranch(), student.getYear(), student.getSemester()}
        );
    }

}

