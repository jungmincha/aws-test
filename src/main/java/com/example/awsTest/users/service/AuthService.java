package com.example.awsTest.users.service;

import com.example.awsTest.jwt.TokenProvider;
import com.example.awsTest.users.dto.LoginDto;
import com.example.awsTest.users.dto.TokenDto;
import com.example.awsTest.users.dto.UserInfoDto;
import com.example.awsTest.users.entity.Users;
import com.example.awsTest.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final TokenProvider tokenProvider;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final UsersRepository usersRepository;
    public TokenDto authorize(LoginDto loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());//토큰 객체 생성

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);//토큰 객체가 실행될 대 loadbyusername 메서드가 실행, 그걸 시큐리티에 저장

        String jwt = tokenProvider.createToken(authentication); //jwt 생성

        return new TokenDto(jwt);

    }

    public UserInfoDto getUserInfo(TokenDto tokenDto) {
        //        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + tokenDto.getToken());//header에 넣어줌
        log.info("check token valid : " + tokenProvider.validateToken(tokenDto.getToken()));
        String username = tokenProvider.getAuthentication(tokenDto.getToken()).getName();
        //이름으로 유저 정보 조회
        Users users = usersRepository.findByUsername(username).orElseThrow(()-> new RuntimeException("회원 정보가 없습니다."));
        return new UserInfoDto(users.getUsername(), users.getNickname(), users.getAuthorityName());
    }
}
