package com.example.awsTest.lab;

import com.example.awsTest.users.entity.Users;
import com.example.awsTest.users.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lab")
public class LabController {

    private final UserService userService;


//    @GetMapping("/test")
//    public ResponseEntity<List<Users>> getMemberList() {
//        return ResponseEntity.ok(userService.getMemberList());
//    }

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("hello-world");
    }
}
