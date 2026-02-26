package com.example.backend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins="*")
public class UserController {
    @Autowired 
    UserRepository ur;

    @GetMapping("/demo")
    String demo(){
        return "Hello World";
    }
    @GetMapping("/users")
    String getUsers(){
        return "Hello users ";
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users user) {
        this.ur.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }
}
