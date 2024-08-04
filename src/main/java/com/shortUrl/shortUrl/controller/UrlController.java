package com.shortUrl.shortUrl.controller;

import com.shortUrl.shortUrl.Entity.Url;
import com.shortUrl.shortUrl.dto.ShortUrlResponse;
import com.shortUrl.shortUrl.dto.UrlDTO;
import com.shortUrl.shortUrl.repository.UrlRepository;
import com.shortUrl.shortUrl.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
