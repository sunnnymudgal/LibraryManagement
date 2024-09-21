package com.myprojects.LibraryManagement.services;

import com.myprojects.LibraryManagement.entities.Books;
import com.myprojects.LibraryManagement.entities.Students;
import com.myprojects.LibraryManagement.repository.StudentsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class StudentsService {
    @Autowired
    private StudentsRepo studentsRepo;

    public void saveInfo(Students students){
        try{
            studentsRepo.save(students);
        }catch(Exception e){
            log.error("e: ", e);
        }
    }

    public List<Students> getAll(){
        return studentsRepo.findAll();
    }

    public Optional<Students> findById(String id){
        return studentsRepo.findById(String.valueOf(id));
    }

    public void deleteById(String id){
        studentsRepo.deleteById(String.valueOf(id));
    }

    public Students findByStudentName(String studentname){
        return studentsRepo.findByStudentName(studentname);
    }


}
