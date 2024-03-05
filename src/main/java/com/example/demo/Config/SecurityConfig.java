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
        http.formLogin(login -> login
                // 指定したURLがリクエストされるとログイン認証を行う。
                .loginProcessingUrl("/login")

                // ログイン時のURLの指定
                .loginPage("/login")

                // 認証成功後にリダイレクトする場所の指定
                .defaultSuccessUrl("/menu")

                // ログインに失敗した時のURL
                .failureUrl("/loginError")

                // login.htmlのユーザーIDのname
                .usernameParameter("user_id")

                // login.htmlのパスワードのname
                .passwordParameter("password")

                //アクセス権限の有無（permitAllは全てのユーザーがアクセス可能)
                .permitAll()
        ).logout(logout -> logout
                        .logoutSuccessUrl("/")

                //アクセス制限
        ).authorizeHttpRequests(ahr -> ahr
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .requestMatchers("/").permitAll()

                //"/admin"はADMIN権限のあるものだけがアクセスできる
                .requestMatchers("/admin").hasRole("ADMIN")

                //他のリンクは全て認証が必要である。
                .anyRequest().authenticated()
        );
        return http.build();
    }
}
