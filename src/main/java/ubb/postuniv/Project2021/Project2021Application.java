package ubb.postuniv.Project2021;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ubb.postuniv.Project2021.model.Test;
import ubb.postuniv.Project2021.repository.TestRepository;

@SpringBootApplication
public class Project2021Application {

	public static void main(String[] args) {

		SpringApplication.run(Project2021Application.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(TestRepository testRepository) {

		return args -> {
			testRepository.save(new Test("test1"));
			testRepository.save(new Test("test2"));
		};
	}

}
