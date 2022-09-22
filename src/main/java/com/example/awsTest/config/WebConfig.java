package com.example.awsTest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
//http://devstory.ibksplatform.com/2020/03/spring-boot-pageable.html

//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//
//        PageableHandlerMethodArgumentResolver pageablergumentResolver =
//            new PageableHandlerMethodArgumentResolver();//: Paging에 대한 설정을 수정하는 Resolver
//
//            pageablergumentResolver.setOneIndexedParameters(true); //true = page 기본값을 1로 설정
//
//            pageablergumentResolver.setFallbackPageable(PageRequest.of(0, 10 , Sort.Direction.DESC , "bid"));
//            //page = 0 , size = 10 , sort = bid 최신순
//
//        argumentResolvers.add(pageablergumentResolver);
//
//    }
//
//}
