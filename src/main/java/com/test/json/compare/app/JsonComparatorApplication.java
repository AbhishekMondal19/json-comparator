package com.test.json.compare.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class JsonComparatorApplication {

	public static void main(String[] args) {

		SpringApplication.run(JsonComparatorApplication.class, args);
	}

}
