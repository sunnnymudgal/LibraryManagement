package com.myprojects.LibraryManagement.controllers;

import com.myprojects.LibraryManagement.entities.Books;
import com.myprojects.LibraryManagement.entities.Students;
import com.myprojects.LibraryManagement.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FrontController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Students());
        return "registerStudent";
    }







}
