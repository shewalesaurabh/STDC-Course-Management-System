package com.cdac;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.cdac.services.UserService;

@SpringBootApplication
@EnableJpaAuditing
public class STDCCourseManagement {
	
	private static final Logger log = LoggerFactory.getLogger(STDCCourseManagement.class);

	public static void main(String[] args) {
		SpringApplication.run(STDCCourseManagement.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(UserService srv) {
	    return (args) -> {
    		srv.createAdmin();
    		log.info("Admin user created successfully");
	    };
	}

}
