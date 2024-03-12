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
        List<UserEntity> userList = menuService.findAll();
        System.out.printf("ID："+userList.get(0).getId()+
                "　pass："+userList.get(0).getPassword()+
                "　名前："+userList.get(0).getUserName());

        return "menu";
    }
}
