package com.wolknashatle.loandataservice.config;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Value("${mongodb.host:localhost}")
    private String host;

    @Value("${mongodb.port}")
    private String port;

    @Value("${mongodb.database}")
    private String database;

    @Value("${mongodb.collection}")
    private String collection;

    @Bean
    public MongoClient getMongoClient () { return new MongoClient(host, Integer.parseInt(port)); }

    @Bean
    public DB getDb(){ return getMongoClient().getDB(database); }

    @Bean
    public DBCollection getTable() { return  getDb().getCollection(collection);}







}
