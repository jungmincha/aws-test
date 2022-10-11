package com.example.awsTest.users.service;

import com.example.awsTest.users.dto.LoginDto;
import com.example.awsTest.users.dto.UserDto;
import com.example.awsTest.users.entity.Authority;
import com.example.awsTest.users.entity.Users;
import com.example.awsTest.users.repository.UsersRepository;
import com.example.awsTest.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;
    public UserService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users signUp(UserDto userDto) {
        Users checkUserName = usersRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null); //요청정보의 username으로 조회한 값이 있으면 예외처리
        if(!ObjectUtils.isEmpty(checkUserName)) throw new RuntimeException("이미 가입되어 있는 유저입니다.");

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();//ROLE_USER 권한정보

        Users user = Users.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .authorities(Collections.singleton(authority))
                .authorityName("ROLE_USER")
                .activated(true)
                .delYn("N")
                .build();

        return usersRepository.save(user);

    }

    public Optional<Users> getUserWithAuthorities(String username) {
        return usersRepository.findOneWithAuthoritiesByUsername(username);
    }

    public Optional<Users> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(usersRepository::findOneWithAuthoritiesByUsername);
    }

    public List<Users> getAllMembers() {
        return usersRepository.findAll();
    }
}
