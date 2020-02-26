package com.example.spring.security5.roleauthority;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping
    //@PreAuthorize("hasRole('USER')")
    public String findAll(){
        return "list";
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('delete')")
    public Long delete(@PathVariable Long id){
        return id;
    }

}
