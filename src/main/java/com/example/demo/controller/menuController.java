package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class menuController {
    @GetMapping("/menu")
    private String loginSuccess(){
        return "menu";
    }
}
