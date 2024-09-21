package com.myprojects.LibraryManagement.repository;

import com.myprojects.LibraryManagement.entities.Books;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BooksRepo extends MongoRepository<Books,String> {
    Books findByAuthor(String authorName);
}
