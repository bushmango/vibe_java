package com.example.vibejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Application entry point that boots the embedded server and Spring context.
@SpringBootApplication
public class VibeJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VibeJavaApplication.class, args);
	}

}
