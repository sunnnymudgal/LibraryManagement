package com.myprojects.LibraryManagement.entities;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Indexed;

import java.time.LocalDateTime;

@Component
@Data
public class Books {
    @Id
    private String id;
    private String bookName;
    private String author;
    private LocalDateTime date;

}
