package com.example.spring.mogon;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("employee")
@Data
public class Employee {
    @Id
    private String id;
    private String name;
}
