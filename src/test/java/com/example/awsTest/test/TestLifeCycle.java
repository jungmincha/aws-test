//package com.example.awsTest.test;
//
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.*;
//import org.springframework.boot.test.context.SpringBootTest;
//
//public class TestLifeCycle {
//
//    @BeforeAll
//    static void beforeAll() {
//        System.out.println("=== BeforeAll 어노테이션 호출 ===");
//        System.out.println("==============================");
//    }
//
//    @AfterAll
//    static void afterAll() {
//        System.out.println("=== AfterAll 어노테이션 호출 ===");
//        System.out.println("==============================");
//    }
//
//    @BeforeEach
//    static void beforeEach() {
//        System.out.println("=== BeforeEach 어노테이션 호출 ===");
//        System.out.println("==============================");
//    }
//
//    @AfterEach
//    static void afterEach() {
//        System.out.println("=== AfterEach 어노테이션 호출 ===");
//        System.out.println("==============================");
//    }
//
//    @Test
//    void test1() {
//        System.out.println("=== test1 시작 ===");
//        System.out.println("==================");
//    }
//
//    @Test
//    @DisplayName("test case 2")
//    void test2() {
//        System.out.println("=== test2 시작 ===");
//        System.out.println("==================");
//    }
//
//    @Test
//    @Disabled
//    void test3() {
//        System.out.println("=== test3 시작 ===");
//        System.out.println("==================");
//    }
//}
