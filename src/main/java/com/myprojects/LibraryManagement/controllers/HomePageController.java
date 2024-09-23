package com.myprojects.LibraryManagement.controllers;

import com.myprojects.LibraryManagement.entities.Students;

import com.myprojects.LibraryManagement.services.BooksService;
import com.myprojects.LibraryManagement.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/home")
public class HomePageController {

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private BooksService booksService;

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        List<Students> all = studentsService.getAll();
        if(all!=null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/register-process")
    public ResponseEntity<?> registerStudent(@ModelAttribute("student") Students student) {
        try {
            studentsService.saveInfo(student);  // Save student info
            return ResponseEntity.status(HttpStatus.CREATED).body("Registration successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Registration failed: " + e.getMessage());
        }
    }

    @PutMapping("/id/{myId}")
    public ResponseEntity<?> editStudent(@PathVariable("myId") String id, @RequestBody Students studentInfo){
        Students old = studentsService.findById(id).orElse(null);
        if(old != null ){
            old.setStudentName(studentInfo.getStudentName()!=null && !studentInfo.getStudentName().equals("")? studentInfo.getStudentName() : old.getStudentName());
            studentsService.saveInfo(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<?> getStudentById(@PathVariable("myId") String myId) {
        Optional<Students> student = studentsService.findById(myId);
        if(student.isPresent()){
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id/{myId}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("myId") String myId) {
        studentsService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
