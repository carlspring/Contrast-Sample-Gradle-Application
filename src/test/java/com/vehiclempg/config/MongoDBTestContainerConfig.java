package com.vehiclempg.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.testcontainers.junit.jupiter.Container;

import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * @author carlspring
 */
@Configuration
@EnableMongoRepositories
public class MongoDBTestContainerConfig {

    @Container
    public static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest").withExposedPorts(27017);

    static {
        mongoDBContainer.start();

        var host = mongoDBContainer.getHost();
        var port = mongoDBContainer.getMappedPort(27017);

        System.setProperty("mongodb.container.host", host);
        System.setProperty("mongodb.container.port", String.valueOf(port));
    }

}
