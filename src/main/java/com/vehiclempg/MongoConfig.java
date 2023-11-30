package com.vehiclempg;

import com.mongodb.client.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

//import com.mongodb.Mongo;
//import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@Deprecated
public class MongoConfig extends AbstractMongoClientConfiguration {

//    @Override
//    @Bean
//    public Mongo mongo() throws Exception {
//        return new MongoClient("localhost:27017");
//    }

    @Override
    protected String getDatabaseName() {
        return "vehicles";
    }

//    @Override
//    protected String getMappingBasePackage() {
//        return "com.vehiclempg.repositories";
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws Exception {
//        return new MongoTemplate(mongo(), getDatabaseName());
//    }


}
