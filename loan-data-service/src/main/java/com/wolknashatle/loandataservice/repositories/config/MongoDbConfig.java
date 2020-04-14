package com.wolknashatle.loandataservice.repositories.config;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = {"com.wolknashatle.loandataservice.repositories"})
public class MongoDbConfig {

}
