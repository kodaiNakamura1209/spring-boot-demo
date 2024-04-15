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

    // メニューへ遷移
    @GetMapping("/loginMenu")
    private String loginMenu(Model model){
        System.out.println("----MenuController  START------------");

        // データ取得
        List<UserEntity> userList = menuService.findAll();
        UserEntity user = userList.get(0);

        // 画面に情報を渡す
        model.addAttribute("userObject", user);

        System.out.println("----MenuController  END------------");
        return "menu";
    }
}
