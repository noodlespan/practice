package com.example.springredislettucecrud.controller;

import com.example.springredislettucecrud.entity.Employee;
import com.example.springredislettucecrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Boolean save(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return Boolean.TRUE;
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable String id){

        return employeeRepository.findById(id).orElse(null);
    }

    @PutMapping
    public Boolean update(@RequestBody Employee employee){
        employeeRepository.save(employee);
        return Boolean.TRUE;
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable String id){
        employeeRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @GetMapping("/findByName/{name}")
    public Page<Employee> findByName(@PathVariable String name , @PageableDefault Pageable pageable){
      /*  Employee searchEmployee =new Employee();
        searchEmployee.setName(name);
        Example<Employee> employeeExample = Example.of(searchEmployee);
        //return employeeRepository.findAll(employeeExample,pageable);*/
        return employeeRepository.findAllByName(name,pageable);
    }

}
