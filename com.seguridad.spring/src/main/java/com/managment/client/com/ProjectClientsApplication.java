package com.managment.client.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootApplication
public class ProjectClientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectClientsApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedOrigins("/**").allowedMethods("*").allowedHeaders("*");
			}
		};
	}

}
