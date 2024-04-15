package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {

    private final SignupService signupService;

    @Autowired
    public SignupController(SignupService signupService) {this.signupService = signupService;}

    @GetMapping("/signup/view")
    private String view(){
        System.out.println("----SignupController view  START------------");
        System.out.println("----SignupController view  END------------");
        return "signup";
    }

    @GetMapping("/signup/doInsert")
    private String doInsert(@RequestParam String inputUserName, @RequestParam String inputUserId, @RequestParam String inputUserPass){
        System.out.println("----SignupController doInsert  START------------");

        // 画面遷移先
        String result = "";

        // Entityに入力値を格納
        UserEntity insertUserEntity = new UserEntity();
        insertUserEntity.setUserName(inputUserName);
        insertUserEntity.setId(inputUserId);
        insertUserEntity.setPassword(inputUserPass);

        // 入力IDチェックを行う
        if (signupService.checkId(inputUserId)){
            // 新規登録メソッドを呼び出し
            signupService.insertUserEntity(insertUserEntity);
            result = "login";
        } else {
            // 入力チェックエラーの場合はエラー画面へ
            result = "loginError";
        }

        System.out.println("----SignupController doInsert  END------------");
        return result;
    }
}
