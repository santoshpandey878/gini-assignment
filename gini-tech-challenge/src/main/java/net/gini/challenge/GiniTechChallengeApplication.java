package net.gini.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Application main class
 * Flow start from this class
 */
@SpringBootApplication
@EnableTransactionManagement
public class GiniTechChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GiniTechChallengeApplication.class, args);
	}

}
