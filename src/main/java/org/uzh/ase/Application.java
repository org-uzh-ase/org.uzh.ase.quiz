package org.uzh.ase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@PropertySource({ "classpath:application-${env:local}.properties" })
public class Application{

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	@SuppressWarnings("java:S5122") // We had problems getting the containers to work and decided to relax the allowed origins
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/quizzes/quiz").allowedOrigins("*");
			}
		};
	}

}
