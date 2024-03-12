package com.example.demo.provider;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.CustomAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final CustomAuthenticationService customAuthenticationService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomAuthenticationProvider(CustomAuthenticationService customAuthenticationService, PasswordEncoder passwordEncoder){
        this.customAuthenticationService = customAuthenticationService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        // ブラウザから入力したユーザ名・パスワードを取得
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserEntity userEntity = customAuthenticationService.findById(username);
        if (passwordEncoder.matches(password, userEntity.getPassword())){
            return new UsernamePasswordAuthenticationToken(username, password);
        } else {
            throw new BadCredentialsException("Authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
