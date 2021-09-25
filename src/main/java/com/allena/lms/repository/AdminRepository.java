package com.allena.lms.repository;

import com.allena.lms.db.JdbcTemplate;
import com.allena.lms.dto.LoginDTO;
import com.allena.lms.mapper.AdminMapper;
import com.allena.lms.model.Admin;

public class AdminRepository {

    private final JdbcTemplate<Admin> adminJdbcTemplate = new JdbcTemplate<>();

    public Admin getAdminByEmailAndPassword(LoginDTO login) throws Exception {
        return adminJdbcTemplate.getByObject(
                "SELECT * FROM TBL_ADMINS WHERE email=? AND password=?",
                new Object[]{login.getEmail(), login.getPassword()},
                new AdminMapper()
        );
    }
}
