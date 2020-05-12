package com.example.jpamysqlencrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRep employeeRep;

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        Employee employee = employeeRep.findById(id).get();
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Employee employee) {
        employeeRep.save(employee);
        return ResponseEntity.ok(employee);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Employee employee){
        employeeRep.save(employee);
        return ResponseEntity.ok(employee);
    }
}
