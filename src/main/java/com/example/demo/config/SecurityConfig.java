package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin((form) -> form
                // 指定したURLがリクエストされるとログイン認証を行う。
                .loginProcessingUrl("/login")

                // ログイン時のURLの指定
                .loginPage("/login")

                // 認証成功後にリダイレクトする場所の指定
                .defaultSuccessUrl("/loginMenu")

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
                .requestMatchers("/loginMenu").permitAll()
                .requestMatchers("/signup/view").permitAll()
                .requestMatchers("/dataUpdate/view").permitAll()
                .requestMatchers("/dataUpdate/doUpdate").permitAll()
                .requestMatchers("/dataDelete/view").permitAll()
                .anyRequest().authenticated()
        );
        return http.build();
    }
}
