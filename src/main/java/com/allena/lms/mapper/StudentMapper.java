package com.allena.lms.mapper;


import com.allena.lms.db.RowMapper;
import com.allena.lms.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student map(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setCourse(resultSet.getString("course"));
        student.setBranch(resultSet.getString("branch"));
        student.setSemester(resultSet.getInt("semester"));
        student.setYear(resultSet.getInt("year"));
        return student;
    }
}
