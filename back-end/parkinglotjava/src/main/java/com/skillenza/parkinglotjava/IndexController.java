package com.skillenza.parkinglotjava;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/")
public class IndexController {
	
	@CrossOrigin(origins = "*")
    @GetMapping
    public String sayHello() {
        return "App working";
    }
}