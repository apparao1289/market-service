package com.test.vegetable.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The Class MarketServiceApplication defines the application entry point with
 * Spring boot.
 * 
 * @author apparao
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.test.vegetable")
@EnableJpaRepositories(basePackages = { "com.test.vegetable.dao.repository" })
@EntityScan(basePackages = "com.test.vegetable.dao.entity")
public class MarketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketServiceApplication.class, args);
	}
}
