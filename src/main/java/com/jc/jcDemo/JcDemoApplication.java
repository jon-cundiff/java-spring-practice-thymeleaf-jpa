package com.jc.jcDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JcDemoApplication {
	private static final Logger log = LoggerFactory.getLogger(JcDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JcDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo (UserRepository repository) {
		return (args) -> {
			// Create some users
//			repository.save(new User("Jon", "Cundiff"));
//			repository.save(new User("John", "Johnson"));
//			repository.save(new User("Jack", "Jackson"));
//			repository.save(new User("Jacob", "Jacobson"));

			log.info("Users with findAll():");
			log.info("---------------------");
			for (User user : repository.findAll()) {
				log.info(user.toString());
			}

			User user = repository.findById(4L);
			log.info("User found with findById(1L)");
			log.info("----------------------------");
			log.info(user.toString());

			log.info("User found with findByLastName('Johnson')");
			log.info("-----------------------------------------");
			repository.findByLastName("Johnson").forEach(userLast -> log.info(userLast.toString()));
		};
	}
}
