package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginErrorController {
    @GetMapping("/loginError")
    private String loginError(){
        return "loginError";
    }
}
