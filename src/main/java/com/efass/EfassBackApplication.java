package com.efass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class EfassBackApplication extends SpringBootServletInitializer {


	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EfassBackApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(EfassBackApplication.class, args);
	}
}
