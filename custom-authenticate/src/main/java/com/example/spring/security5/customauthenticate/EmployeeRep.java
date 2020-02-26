package com.example.spring.security5.customauthenticate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRep extends JpaRepository<Employee,Long> {

    Optional<Employee> findByName(String name);
}
