package com.example.awsTest.users.controller;

import com.example.awsTest.jwt.JwtFilter;
import com.example.awsTest.jwt.TokenProvider;
import com.example.awsTest.users.dto.LoginDto;
import com.example.awsTest.users.dto.TokenDto;
import com.example.awsTest.users.dto.UserInfoDto;
import com.example.awsTest.users.entity.Users;
import com.example.awsTest.users.repository.UsersRepository;
import com.example.awsTest.users.service.AuthService;
import com.example.awsTest.users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.ObjectInputFilter;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/authenticate")
    public ResponseEntity<TokenDto> authorize(@Valid @RequestBody LoginDto loginDto) {//파라미터
        return ResponseEntity.ok(authService.authorize(loginDto));

    }

    @PostMapping("/authenticate/getUserInfo")
    public ResponseEntity<UserInfoDto> getUserInfo(@RequestBody TokenDto tokenDto) {//파라미터
        return ResponseEntity.ok(authService.getUserInfo(tokenDto));
    }
}
