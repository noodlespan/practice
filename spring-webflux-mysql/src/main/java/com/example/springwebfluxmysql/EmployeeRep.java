package com.example.springwebfluxmysql;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRep extends ReactiveCrudRepository<Employee,Long> {
}
