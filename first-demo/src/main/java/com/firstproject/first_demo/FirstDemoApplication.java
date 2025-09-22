package com.firstproject.first_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class FirstDemoApplication {
 @GetMapping("/hello")
    public String check() {
        return "Hello World";
    }
	public static void main(String[] args) {
		SpringApplication.run(FirstDemoApplication.class, args);
	}

}
