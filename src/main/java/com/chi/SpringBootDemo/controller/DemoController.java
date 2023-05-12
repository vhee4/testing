package com.chi.SpringBootDemo.controller;

import com.chi.SpringBootDemo.dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DemoController {


   @GetMapping("/greeting")
   public String greeting(){
        return "Hello guys";
    }

    @GetMapping("/welcome")
    public String welcome(){
       return "You're welcome to our class";
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest request){
       String message;
       if(request.getUsername().equalsIgnoreCase("iacademy") && request.getPassword().equalsIgnoreCase("1234")){
           message = "You have successfully logged in";
           return ResponseEntity.ok(message);
       }
       message = "Login failed";
        return ResponseEntity.badRequest().body(message);
    }
}
