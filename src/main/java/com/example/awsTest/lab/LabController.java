package com.example.awsTest.lab;

import com.example.awsTest.users.entity.Users;
import com.example.awsTest.users.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lab")
public class LabController {

    private final UserService userService;
    private final LabService labService;



    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("hello-world");
    }

    @GetMapping("/exceldownload")
    public ResponseEntity getExcelDownLoad(HttpServletResponse response) {
        labService.getExcelDownLoad(response);
        return ResponseEntity.ok("success");
    }
}
