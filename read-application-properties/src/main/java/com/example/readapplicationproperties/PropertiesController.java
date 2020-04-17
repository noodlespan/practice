package com.example.readapplicationproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertiesController {

    @Value("${string.value}")
    private String stringValue;
    private static String staticStringValue;
    @Value("#{'${list.values}'.split(' ')}")
    private String [] listValues;
    
    @Autowired
    private MailProperties mailProperties;

    @GetMapping("/mail")
    public MailProperties getMail(){
        return mailProperties;
    }

    @GetMapping("/list")
    public String [] list(){
        return listValues;
    }

    @GetMapping("/string")
    public String string(){
        return stringValue;
    }

    @GetMapping("/static-string")
    public String staticString(){
        return staticStringValue;
    }

    @Autowired
    private void setStaticStringValue(@Value("${string.value}") String stringValue){
        staticStringValue = stringValue;
    }
}
