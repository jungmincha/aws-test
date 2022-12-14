package com.example.awsTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AwsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsTestApplication.class, args);
	}

}
