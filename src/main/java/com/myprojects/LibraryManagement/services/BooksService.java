package com.myprojects.LibraryManagement.services;

import com.myprojects.LibraryManagement.entities.Books;
import com.myprojects.LibraryManagement.entities.Students;
import com.myprojects.LibraryManagement.repository.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class BooksService{

    @Autowired
    public BooksRepo booksRepo;

    @Autowired
    public StudentsService studentsService;

    @Transactional
    public void saveInfo(Books books, String name){
        Students student = studentsService.findByStudentName(name);
        books.setDate(LocalDateTime.now());
        Books saved = booksRepo.save(books);
        student.getBooks().add(saved);
        studentsService.saveInfo(student);
    }

    public void saveInfo(Books books){
        booksRepo.save(books);
    }

    public List<Books> getAll(){
        return booksRepo.findAll();
    }

    public Optional<Books> findById(String id){
        return booksRepo.findById(String.valueOf(id));
    }

    public void deleteById(String id, String name){
        Students student = studentsService.findByStudentName(name);
        student.getBooks().removeIf(x->x.getId().equals(id));
        studentsService.saveInfo(student);
        booksRepo.deleteById(String.valueOf(id));
    }

    public Books findByAuthor(String author){
        return booksRepo.findByAuthor(author);
    }
}
