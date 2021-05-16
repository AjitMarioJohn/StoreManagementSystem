package com.sms.itemMgmt.itemMgmtBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@ComponentScan(value = "com.sms.itemMgmt")
@EnableJpaRepositories(value = "com.sms.itemMgmt.infra.repositories")
@EntityScan(value = "com.sms.itemMgmt.infra.entities")
public class ItemMgmtBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(ItemMgmtBootApplication.class, args);
	}
}
