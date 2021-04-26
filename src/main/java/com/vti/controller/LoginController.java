package com.vti.controller;

import com.vti.dto.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vti.service.IAdminService;

@RestController
@RequestMapping(value = "api/v1/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private IAdminService adminService;

    @PostMapping()
    public ResponseEntity<?> login(@RequestBody AdminDto adminDto) {
        Boolean login = adminService.login(adminDto);
        return new ResponseEntity<Boolean>(login, HttpStatus.OK);
    }
}