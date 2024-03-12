package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional  // DBのトランザクション制御
@Service        // サービスクラスであることを明示　クラスのBeanをDIコンテナに登録する
public class CustomAuthenticationService {

    private final UserRepository userRepository;

    @Autowired
    public CustomAuthenticationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public UserEntity findById(String userId){
        // orElse・・・メソッドの戻り値としてnullを返す可能性を明示　nullの場合は引数の値を返す
        return  userRepository.findById(userId).orElse(new UserEntity());
    }
}
