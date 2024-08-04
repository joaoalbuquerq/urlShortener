package com.shortUrl.shortUrl.controller;

import com.shortUrl.shortUrl.Entity.Url;
import com.shortUrl.shortUrl.dto.ShortUrlResponse;
import com.shortUrl.shortUrl.dto.UrlDTO;
import com.shortUrl.shortUrl.repository.UrlRepository;
import com.shortUrl.shortUrl.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
public class UrlController {

    @Autowired
    UrlService service;

    @PostMapping("/short-url")
    public ResponseEntity<ShortUrlResponse> shortUrl(@RequestBody UrlDTO dto, HttpServletRequest req){

        var url = service.saveUrl(dto);
        String redirectUrl = "";
        if(url != null){
             redirectUrl = req.getRequestURL().toString().replace("short-url", url.getId());
        }

        return ResponseEntity.ok(new ShortUrlResponse(redirectUrl));
    }

    @GetMapping("{id}")
    public ResponseEntity<Void> redirect(@PathVariable("id") String id){
        var url = service.findUrl(id);

        if(url.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        HttpHeaders head = new HttpHeaders();
        head.setLocation(URI.create(url.get().getFullUrl()));

        return ResponseEntity.status(HttpStatus.FOUND).headers(head).build();

    }
}
