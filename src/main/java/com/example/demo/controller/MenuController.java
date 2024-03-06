package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }
    @GetMapping("/menu")
    private String loginSuccess(){

        // データ取得
        List<UserEntity> users = menuService.findAll();
        System.out.printf(users.toString());

        return "menu";
    }
}
