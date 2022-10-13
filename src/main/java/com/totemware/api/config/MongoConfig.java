package com.totemware.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@Configuration
public class MongoConfig {

    private final MappingMongoConverter mongoConverter;
    private final MongoDatabaseFactory mongoDatabaseFactory;

    public MongoConfig(MappingMongoConverter mongoConverter, MongoDatabaseFactory mongoDatabaseFactory){
        this.mongoConverter = mongoConverter;
        this.mongoDatabaseFactory = mongoDatabaseFactory;
    }

    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception{
        return new GridFsTemplate(mongoDatabaseFactory, mongoConverter);
    }
}
