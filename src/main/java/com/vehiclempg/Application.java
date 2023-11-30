package com.vehiclempg;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = { "com.vehiclempg" })
//@EnableJpaRepositories(basePackages = "com.vehiclempg.repositories")
@EnableTransactionManagement
//@EntityScan(basePackages = "com.vehiclempg.entities")
@EnableMongoRepositories(basePackages = "com.vehiclempg.repositories")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(new Class[]{Application.class, AppInitializer.class}, args);
    }
}
