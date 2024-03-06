package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Transactional  // DBのトランザクション制御
@Service        // サービスクラスであることを明示　クラスのBeanをDIコンテナに登録する
public class MenuService {

    private final UserRepository userRepository;

    @Autowired
    public MenuService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }
}
