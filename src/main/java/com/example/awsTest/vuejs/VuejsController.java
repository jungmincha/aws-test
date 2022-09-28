package com.example.awsTest.vuejs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class VuejsController {

    @GetMapping("/vue")//jpa로 작성한 게시판 읽기
    public String vue(){
        log.info("vue-test");
        return "vue/index";

    }
}
