package com.example.springlogging;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
//@Log4j2
public class LoggerController {
    private static final Logger log = LoggerFactory.getLogger(LoggerController.class);

    @GetMapping("/logger")
    public String logger(){
        log.trace("This is a trace msg:{}",new Date());
        log.debug("This is a debug msg:{}",new Date());
        log.info("This is a info msg:{}",new Date());
        log.warn("This is a warn msg:{}",new Date());
        log.error("This is a error msg:{}",new Date());
        return "OK";
    }
}
