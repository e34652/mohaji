package com.team1.mohaji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditAwareImpl")
@EnableTransactionManagement
public class MohajiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MohajiApplication.class, args);
	}

}
