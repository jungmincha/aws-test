package com.example.awsTest.vuejs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class VuejsController {

    @GetMapping("/")//jpa로 작성한 게시판 읽기
    public String vue(){
        log.info("vue-test");
        return "vue/index";

    }

//    @GetMapping("/vue/board")//jpa로 작성한 게시판 읽기
//    public String boardList(){
//        log.info("vue-boardList");
//        return "vue/index";
//    }
}
