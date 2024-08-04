package com.shortUrl.shortUrl.service;

import com.shortUrl.shortUrl.Entity.Url;
import com.shortUrl.shortUrl.dto.UrlDTO;
import com.shortUrl.shortUrl.repository.UrlRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UrlService {

    @Autowired
    UrlRepository repository;

    public Url saveUrl(UrlDTO dto){
        String id;

        do{
            id = RandomStringUtils.randomAlphabetic(5,10);
        }while (repository.existsById(id));

        return repository.save(new Url(id, dto.url(), LocalDateTime.now().plusMinutes(2)));
    }

    public Optional<Url> findUrl(String id) {
        return repository.findById(id);
    }
}
