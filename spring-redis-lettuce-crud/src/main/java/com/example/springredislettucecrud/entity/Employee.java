package com.example.springredislettucecrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Data
@RedisHash("Employees")
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    @Id
    private String id;
    @Indexed
    private String name;
    private Integer age;
}
