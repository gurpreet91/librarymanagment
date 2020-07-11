package com.app.librarymanagment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan("com.app.*")
public class ApplicationConfig {
	
	public static void main(String[] args) {
		
		SpringApplication.run(ApplicationConfig.class, args);

		;
		
//		new WebContextHolder().getSession().setAttribute("webContext", new ArrayList<UserRegistration>());

	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:9093");
			}
		};
	}

}//applicationConfig
