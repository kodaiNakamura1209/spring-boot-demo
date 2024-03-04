package com.example.demo.Config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // アクセス制限
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/").permitAll()

                        // 他のリンクは全て認証が必要
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        // ログインページへのパスを指定→コントローラーにもGET、/loginでの処理を記載する必要がある
                        .loginPage("/login")
                        // ログイン成功時に表示される画面へのパス
                        .defaultSuccessUrl("/menu")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }
}
