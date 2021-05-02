package com.github.springsecurity.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/*@Configuration
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class})*/
public class MongoConnection {

    @Bean
    public MongoClient getMongoClient() {
       /* System.setProperty("javax.net.ssl.trustStore", "C:\\certificates\\mongo-trust.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");*/

        final String mongoURI = "mongodb://admin:orangeadmin@e0c60b20-ea7e-46fb-963d-f53ad0d100e9-0.bkvfvtld0lmh0umkfi70.databases.appdomain.cloud:30750,e0c60b20-ea7e-46fb-963d-f53ad0d100e9-1.bkvfvtld0lmh0umkfi70.databases.appdomain.cloud:30750/ibmclouddb?authSource=admin&replicaSet=replset&ssl=true";

        MongoClient mongoClient = MongoClients.create(mongoURI);
        return mongoClient;

    }
}