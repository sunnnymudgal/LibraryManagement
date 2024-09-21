package com.myprojects.LibraryManagement.repository;

import com.myprojects.LibraryManagement.entities.Books;
import com.myprojects.LibraryManagement.entities.Students;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentsRepo extends MongoRepository<Students,String> {
    Students findByStudentName(String studentName);
}
