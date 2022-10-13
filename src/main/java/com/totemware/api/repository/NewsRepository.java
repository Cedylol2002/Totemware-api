package com.totemware.api.repository;

import com.totemware.api.model.NewsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepository extends MongoRepository<NewsModel, String> {}
