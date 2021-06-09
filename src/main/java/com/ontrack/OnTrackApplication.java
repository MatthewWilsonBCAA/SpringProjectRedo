package com.ontrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OnTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnTrackApplication.class, args);
	}

}
