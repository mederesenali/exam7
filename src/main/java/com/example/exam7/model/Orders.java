package com.example.exam7.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Document
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Orders {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    @Id
    @GeneratedValue
    private   String id;
    @DBRef
    private Client client;
    @DBRef
    private Restoran restoran;
    private LocalDateTime orderDate;


    public static Orders random(Client client, Restoran restoran) {
        return builder()
                .client(client)
                .restoran(restoran)
                .orderDate(LocalDateTime.now())
                .build();
    }


}
