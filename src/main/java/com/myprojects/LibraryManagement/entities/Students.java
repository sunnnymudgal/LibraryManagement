package com.myprojects.LibraryManagement.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Document(collection = "student_list")
@NoArgsConstructor
public class Students {
    @Id
    private String id;
    @NonNull
    private String studentName;
    @DBRef
    private List<Books> books = new ArrayList<>();

}
