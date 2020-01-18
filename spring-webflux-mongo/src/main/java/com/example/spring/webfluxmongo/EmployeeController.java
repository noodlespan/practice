package com.example.spring.webfluxmongo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRep employeeRep;

    @DeleteMapping("/{id}")
    public Mono delete(@PathVariable String id){
        return employeeRep.deleteById(id);
    }

    @GetMapping("/{id}")
    public Mono findById(@PathVariable String id){
        return employeeRep.findById(id);
    }

    @PutMapping
    public Mono update(@RequestBody Employee employee){
        return employeeRep.save(employee);
    }

    @PostMapping
    public Mono<Employee> save(@RequestBody Employee employee){
        return employeeRep.save(employee);
    }

    @GetMapping
    public Flux<Employee> findAll(){
        return employeeRep.findAll();
    }
}
