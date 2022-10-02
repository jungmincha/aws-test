package com.example.awsTest.users.controller;

import com.example.awsTest.users.dto.UserDto;
import com.example.awsTest.users.entity.Users;
import com.example.awsTest.users.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Users> signup(
            @Valid @RequestBody UserDto userDto
    ) {
        return ResponseEntity.ok(userService.signUp(userDto));
    }

    @GetMapping("/test/members")
    public ResponseEntity<List<Users>>getAllMembers() {
        return ResponseEntity.ok(userService.getAllMembers());
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<Users> getMyUserInfo() {
        Users users = userService.getMyUserWithAuthorities().orElse(null);
        System.out.println("sss");
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Users> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserWithAuthorities(username).get());
    }
}