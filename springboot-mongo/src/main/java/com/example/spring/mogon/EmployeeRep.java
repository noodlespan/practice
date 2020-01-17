package com.example.spring.mogon;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRep extends MongoRepository<Employee,String> {
}
