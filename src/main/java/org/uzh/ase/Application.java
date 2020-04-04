package org.uzh.ase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.uzh.ase.quiz.model.Quiz;
import org.uzh.ase.quiz.repository.QuizRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/example").allowedOrigins("http://localhost:4200");
			}
		};
	}

	@Autowired
	private QuizRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		repository.save(new Quiz("imdb_id_example"));
	}
}
