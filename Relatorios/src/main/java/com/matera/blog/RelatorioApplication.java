package com.matera.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RelatorioApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelatorioApplication.class, args);
	}
}
