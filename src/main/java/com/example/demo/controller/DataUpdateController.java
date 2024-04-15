package com.example.demo.controller;

import com.example.demo.service.DataUpdateService;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataUpdateController {

    private final DataUpdateService dataUpdateService;

    @Autowired
    public DataUpdateController(DataUpdateService dataUpdateService){
        this.dataUpdateService = dataUpdateService;
    }

    // データ更新画面に遷移
    @GetMapping("/dataUpdate/view")
    private String index(Model model, @RequestParam String userId){
        System.out.println("----DataUpdateController view  START------------");

        // userIdを次の画面に引き渡す
        model.addAttribute("userId", userId);

        System.out.println("----DataUpdateController view  END------------");
        return "dataUpdate";
    }

    // データ更新処理を実施
    @PostMapping("/dataUpdate/doUpdate")
    private String doUpdate(@RequestParam String userId, @RequestParam String inputUserName){
        System.out.println("----DataUpdateController doUpdate  START------------");

        // データ更新処理を実施
        dataUpdateService.updateUserName(userId, inputUserName);

        System.out.println("----DataUpdateController doUpdate  END------------");
        return "redirect:/loginMenu";
    }

}
