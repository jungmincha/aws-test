package com.example.awsTest.users.controller;

import com.example.awsTest.jwt.JwtFilter;
import com.example.awsTest.jwt.TokenProvider;
import com.example.awsTest.users.dto.LoginDto;
import com.example.awsTest.users.dto.TokenDto;
import com.example.awsTest.users.dto.UserInfoDto;
import com.example.awsTest.users.entity.Users;
import com.example.awsTest.users.repository.UsersRepository;
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

    private final TokenProvider tokenProvider;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final UsersRepository usersRepository;

    @PostMapping("/authenticate")
    public ResponseEntity<TokenDto> authorize(@Valid @RequestBody LoginDto loginDto) {//파라미터
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());//토큰 객체 생성

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);//토큰 객체가 실행될 대 loadbyusername 메서드가 실행, 그걸 시큐리티에 저장

        String jwt = tokenProvider.createToken(authentication); //jwt 생성

        return new ResponseEntity<>(new TokenDto(jwt), HttpStatus.OK); // body에도 넣어줌
    }

    @PostMapping("/authenticate/getUserInfo")
    public ResponseEntity<UserInfoDto> authorize(@RequestBody TokenDto tokenDto) {//파라미터
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + tokenDto.getToken());//header에 넣어줌
        log.info("check token valid : " + tokenProvider.validateToken(tokenDto.getToken()));
//        System.out.println(tokenProvider.validateToken(tokenDto.getToken()));

        String username = tokenProvider.getAuthentication(tokenDto.getToken()).getName();
        //이름으로 유저 정보 조회
        Users users = usersRepository.findByUsername(username).orElseThrow(()-> new RuntimeException("회원 정보가 없습니다."));

        return new ResponseEntity<>(new UserInfoDto(users.getUsername(), users.getNickname(), users.getAuthorityName()), HttpStatus.OK); // body에도 넣어줌
    }
}
