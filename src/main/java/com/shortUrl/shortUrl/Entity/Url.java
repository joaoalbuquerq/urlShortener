package com.shortUrl.shortUrl.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "urls")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Url {

    @Id
    private String id;
    private String fullUrl;

    @Indexed(expireAfterSeconds = 0) //Cria um indice usando TTL, pelo tempo definido, automaticamente ele é excluído pelo banco
    private LocalDateTime expiredAt;
}
