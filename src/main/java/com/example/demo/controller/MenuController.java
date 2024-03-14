package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @GetMapping("/loginSuccess")
    private String loginSuccess(Model model){
        System.out.println("----MenuController  START------------");
        // データ取得
        List<UserEntity> userList = menuService.findAll();
        System.out.println("ID："+userList.get(0).getId()+
                "　pass："+userList.get(0).getPassword()+
                "　名前："+userList.get(0).getUserName());

        UserEntity user = userList.get(0);

        model.addAttribute("userObject", user);

        System.out.println("----MenuController  END------------");
        return "menu";
    }

    @GetMapping("/menu")
    private String menu(){
        System.out.println("----MenuController  START------------");
        return "menu";
    }
}
