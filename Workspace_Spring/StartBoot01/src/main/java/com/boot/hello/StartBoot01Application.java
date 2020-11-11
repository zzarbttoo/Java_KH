package com.boot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class StartBoot01Application {

	public static void main(String[] args) {
		SpringApplication.run(StartBoot01Application.class, args);
	}

	
	//get 방식으로 넘어오는 mapping
	//post로 넘어오면 postmapping
	@GetMapping("/hello")
	public String hello() {
		
		return "hello";
	}
}
