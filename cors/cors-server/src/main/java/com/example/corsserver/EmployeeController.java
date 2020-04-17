package com.example.corsserver;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @DeleteMapping
    public String delete(){
        return "Delete";
    }

    @GetMapping
    public String findById(){
        return "Get";
    }
    @PutMapping
    public String update(){
        return "Put";
    }

    @PostMapping
    public String save(){
        return "Post";
    }
}
