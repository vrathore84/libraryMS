package com.ottawa.library.libraryms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.ottawa.library")
@SpringBootApplication
public class LibrarymsApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(LibrarymsApplication.class);
	
	public static void main(String[] args) {
		LOGGER.info("Entered  Application...");
		SpringApplication.run(LibrarymsApplication.class, args);
	}
	

}

