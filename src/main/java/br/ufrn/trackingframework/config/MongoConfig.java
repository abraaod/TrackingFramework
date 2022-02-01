package br.ufrn.trackingframework.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

//@Configuration
//public class MongoConfig {
//
//    @Value("${app.extension.mongo.host}")
//    private String mongoHost;
//
//    @Value("${app.extension.mongo.database}")
//    private String mongoDatabase;
//
//    @Bean
//    public MongoClient reactiveMongoClient(){
//        return MongoClients.create(mongoHost);
//    }
//
//    @Bean
//    public ReactiveMongoTemplate reactiveMongoTemplate() {
//        return new ReactiveMongoTemplate(reactiveMongoClient(), mongoDatabase);
//    }
//}
