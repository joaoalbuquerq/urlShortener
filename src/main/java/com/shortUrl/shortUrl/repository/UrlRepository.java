package com.shortUrl.shortUrl.repository;

import com.shortUrl.shortUrl.Entity.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url, String> {
}
