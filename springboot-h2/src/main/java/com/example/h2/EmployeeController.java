package com.example.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRep employeeRep;

    @GetMapping("/list")
    public List<Employee> findAll(){
        return employeeRep.findAll();
    }

    @PostMapping("/save")
    public Boolean save(@RequestBody Employee employee){
        employeeRep.save(employee);
        return Boolean.TRUE;
    }
    @PutMapping("/update")
    public Boolean update(@RequestBody Employee employee){
        employeeRep.save(employee);
        return Boolean.TRUE;
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        employeeRep.deleteById(id);
        return Boolean.TRUE;
    }


}
