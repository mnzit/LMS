package com.allena.lms.controller;

import com.allena.lms.dto.LoginDTO;
import com.allena.lms.model.Admin;
import com.allena.lms.repository.AdminRepository;

public class AdminController {

    AdminRepository adminRepository = new AdminRepository();

    public Admin login(LoginDTO login) {
        try {
            Admin admin = adminRepository.getAdminByEmailAndPassword(login);
            return admin;
        }catch (Exception e){
            System.err.println("LOGIN_EXCEPTION: "+ e.getMessage());
            return null;
        }
    }
}
