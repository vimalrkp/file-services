package com.services.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileServicesApplication.class, args);
		System.out.println(FileServicesApplication.class.getSimpleName() + "Started...");
	}

}
