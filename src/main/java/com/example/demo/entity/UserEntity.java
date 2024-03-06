package com.example.demo.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity                         // テーブルとマッピングを行うオブジェクト（Entity)であることを明示
@Table(name = "test_table")     // 対応するテーブル名を明示
@Getter
@Setter
public class UserEntity {

    @Id                     // 主キーに付加
    @Column(name = "id")    // 対応するカラムを明示
    private String id;

    @Column(name="password")
    private String password;

    @Column(name = "user_name")
    private String userName;
}
