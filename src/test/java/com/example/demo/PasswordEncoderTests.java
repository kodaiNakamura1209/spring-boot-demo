package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordEncoderTests {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void contextLoads() {
        System.out.println("↓↓ハッシュ値↓↓");
        System.out.println(passwordEncoder.encode("pass")); // ハッシュ化したい文字列を入れる
    }
}
