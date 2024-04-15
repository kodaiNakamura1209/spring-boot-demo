package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataDeleteController {

    // データ削除確認画面に遷移
    @GetMapping("/dataDelete/view")
    private String index(Model model, @RequestParam String userId){
        System.out.println("----DataDeleteController view  START------------");

        // userIdを次の画面に引き渡す
        model.addAttribute("userId", userId);

        System.out.println("----DataDeleteController view  END------------");
        return "dataDelete";
    }
}
