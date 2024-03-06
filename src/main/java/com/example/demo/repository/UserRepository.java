package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository・・・型変数には、Entityの型と主キーの型を指定する
@Repository // Repositoryであることを表す
public interface UserRepository extends JpaRepository<UserEntity, String> {
    // 基本的なメソッドは自動生成される
}
