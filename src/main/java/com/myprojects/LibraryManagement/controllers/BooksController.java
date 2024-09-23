package com.myprojects.LibraryManagement.controllers;

import com.myprojects.LibraryManagement.entities.Books;
import com.myprojects.LibraryManagement.entities.Students;
import com.myprojects.LibraryManagement.services.BooksService;
import com.myprojects.LibraryManagement.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BooksController {
    @Autowired
    private BooksService booksService;

    @Autowired
    private StudentsService studentsService;

    @GetMapping
    public List<Books> getAllBooks(){
        return  booksService.getAll();
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getAllInfo(@PathVariable("name") String name) {
        Students student = studentsService.findByStudentName(name);
        List<Books> all = student.getBooks();
        if(all!=null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{name}")
    public ResponseEntity<?> create(@ModelAttribute Books books, @PathVariable String name) {
        Students student = studentsService.findByStudentName(name);
        try {
            booksService.saveInfo(books, name);
            return new ResponseEntity<>(books, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("id/{name}/{myId}")
    public ResponseEntity<?> deleteBookInfoById(@PathVariable String myId,@PathVariable String name){
        booksService.deleteById(myId,name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id/{name}/{myId}")
    public ResponseEntity<?> updateBooks(
            @PathVariable("myId") String id,
            @RequestBody Books books
            , @PathVariable String name
    ){
        Books old = booksService.findById(id).orElse(null);
        if(old != null ){
            old.setBookName(books.getBookName()!=null && !books.getBookName().equals("")? books.getBookName() : old.getBookName());
            booksService.saveInfo(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
