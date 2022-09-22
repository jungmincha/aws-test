package com.example.awsTest.users.service;

import com.example.awsTest.users.entity.Users;
import com.example.awsTest.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class UserService {

    private final UsersRepository usersRepository;
    public List<Users> getMemberList() {
        return usersRepository.findAll();
    }
}
