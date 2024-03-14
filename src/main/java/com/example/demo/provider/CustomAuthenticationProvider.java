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
        String userId = authentication.getName();
        String password = authentication.getCredentials().toString();
        String hashPassword = passwordEncoder.encode(authentication.getCredentials().toString());

        UserEntity userEntity = customAuthenticationService.findById(userId);
        if (passwordEncoder.matches(password, userEntity.getHashPassword())){
            System.out.println("OK");
            System.out.println("ID(入力):"+userId+"　ID(DB):"+userEntity.getId());
            System.out.println("PW_HASH(入力):"+hashPassword+"　PW_HASH(DB):"+userEntity.getHashPassword());
            System.out.println("PW(入力):"+password+"　PW(DB):"+userEntity.getPassword());
            return new UsernamePasswordAuthenticationToken(userId, password);
        } else {
            System.out.println("NG");
            System.out.println("ID(入力):"+userId+"　ID(DB):"+userEntity.getId());
            System.out.println("PW_HASH(入力):"+hashPassword+"　PW_HASH(DB):"+userEntity.getHashPassword());
            System.out.println("PW(入力):"+password+"　PW(DB):"+userEntity.getPassword());
            throw new BadCredentialsException("Authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
