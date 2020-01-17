package com.example.spring.mogon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRep employeeRep;

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable String id){
        employeeRep.deleteById(id);
        return Boolean.TRUE;
    }

    @GetMapping("/findById/{id}")
    public Optional<Employee> findById(@PathVariable String id){
        return employeeRep.findById(id);
    }

    @PutMapping("/update")
    public Boolean update(@RequestBody Employee employee){
        employeeRep.save(employee);
        return Boolean.TRUE;
    }

    @PostMapping("/save")
    public Boolean save(@RequestBody Employee employee){
        employeeRep.save(employee);
        return Boolean.TRUE;
    }

    @GetMapping("/list")
    public List<Employee> find(){
        return employeeRep.findAll();
    }



}
