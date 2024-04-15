package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class DataUpdateService {

    private final UserRepository userRepository;

    @Autowired
    public DataUpdateService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // 名前更新処理
    public boolean updateUserName(String userId, String inputUserName){

        // 更新対象のUser情報を取得
        UserEntity userEntity = userRepository.findById(userId).orElse(new UserEntity());

        // ユーザ名に入力値をセットする
        userEntity.setUserName(inputUserName);

        // TEST_TABLEのデータの更新を行う
        userRepository.save(userEntity);
        return true;
    }
}
