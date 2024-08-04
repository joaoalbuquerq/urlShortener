package com.shortUrl.shortUrl.controller;

import com.shortUrl.shortUrl.dto.UrlDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/url")
public class UrlController {

    @PostMapping
    public ResponseEntity<Void> shortUrl(@RequestBody UrlDTO dto){
        return null;
    }

}
