//package com.example.awsTest.util;
//
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class RootController implements ErrorController {
//    // url 직접 접근할 경우 대체 경로 추가
//    private final String ERROR_PATH = "/error";
//
//    @GetMapping(ERROR_PATH)
//    public String redirectRoot(){
//        return "/vue/index";
//    }
//
//    @Override
//    public String getErrorPath() {
//        return null;
//    }
//}
