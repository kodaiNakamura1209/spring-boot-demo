package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SignupService {

    private final UserRepository userRepository;

    @Autowired
    public SignupService(UserRepository userRepository){this.userRepository = userRepository;}


    // 新規登録用メソッド
    public boolean insertUserEntity(UserEntity insertUserEntity){

        // 画面からの入力値をinsertする
        userRepository.save(insertUserEntity);
        return true;
    }

    // ID重複チェック
    public boolean checkId(String userId){
        // チェック結果
        boolean checkResult = true;

        // 重複チェック
        UserEntity userEntity = userRepository.findById(userId).orElse(null);

        // 検索結果がnullの場合、すでに同じIDがある為、失敗とする
        if(userEntity != null){
            checkResult = false;
        }

        return checkResult;
    }
}
