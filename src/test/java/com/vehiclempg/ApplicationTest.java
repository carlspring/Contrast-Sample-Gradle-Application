package com.vehiclempg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.containers.startupcheck.MinimumDurationRunningStartupCheckStrategy;
import org.testcontainers.containers.wait.strategy.HostPortWaitStrategy;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;

@TestConfiguration(proxyBeanMethods = false)
public class ApplicationTest
{
    @Bean
    @ServiceConnection
    MongoDBContainer mongoDbContainer() throws InterruptedException
    {
        return new MongoDBContainer(DockerImageName.parse("mongo:7.0.4"))
                .withExposedPorts(27017)
                .withReuse(false)
                .withStartupCheckStrategy(new MinimumDurationRunningStartupCheckStrategy(Duration.ofSeconds(10)))
                .waitingFor(new HostPortWaitStrategy());
    }

    public static void main(String[] args)
    {
        SpringApplication.from(Application::main).with(ApplicationTest.class).run(args);
    }

}
