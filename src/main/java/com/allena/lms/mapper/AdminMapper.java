package com.allena.lms.mapper;

import com.allena.lms.db.RowMapper;
import com.allena.lms.model.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapper implements RowMapper<Admin> {
    @Override
    public Admin map(ResultSet resultSet) throws SQLException {
        Admin admin = new Admin();
        admin.setId(resultSet.getLong("id"));
        admin.setName(resultSet.getString("name"));
        admin.setEmail(resultSet.getString("email"));
        admin.setPassword(resultSet.getString("password"));
        return admin;
    }
}
