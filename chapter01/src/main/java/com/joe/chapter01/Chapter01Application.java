package com.joe.chapter01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Chapter01Application {

	@Value("${spring.datasource.url}")
	private String url;

	public static void main(String[] args) {
		SpringApplication.run(Chapter01Application.class, args);
	}

	@RequestMapping("/")
	public String index(){
		return "Hi spring boot,joe"+url;
	}
}
