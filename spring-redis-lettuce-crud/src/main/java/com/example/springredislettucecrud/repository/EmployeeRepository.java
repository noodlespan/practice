package com.example.springredislettucecrud.repository;

import com.example.springredislettucecrud.entity.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface EmployeeRepository extends CrudRepository<Employee,String> , QueryByExampleExecutor<Employee> {
    Page<Employee> findAllByName(String name, Pageable pageable);
}
