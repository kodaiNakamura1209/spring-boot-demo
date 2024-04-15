package com.example.demo.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import lombok.Data;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity                         // テーブルとマッピングを行うオブジェクト（Entity)であることを明示
@Table(name = "test_table")     // 対応するテーブル名を明示
@Data
public class UserEntity {

    @Id                     // 主キーに付加
    @Column(name = "id")    // 対応するカラムを明示
    private String id;

    @Column(name="password")
    private String password;
    
    private String hashPassword;

    @Column(name = "user_name")
    private String userName;

    @Column(name="role")
    private String role;
}
