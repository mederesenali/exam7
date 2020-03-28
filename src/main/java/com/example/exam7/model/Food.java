package com.example.exam7.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Document
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public
class Food {
    @Id
    @GeneratedValue
    private String id;

    private String name;
    private String type;

    private int price;


}
