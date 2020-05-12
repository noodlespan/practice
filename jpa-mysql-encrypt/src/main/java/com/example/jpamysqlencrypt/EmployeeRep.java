package com.example.jpamysqlencrypt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRep extends JpaRepository<Employee,Long> {
}
