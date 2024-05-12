package com.team1.mohaji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditAwareImpl")
public class MohajiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MohajiApplication.class, args);
	}

}
