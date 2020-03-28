package com.example.exam7.model;

import com.example.exam7.data.GenerateData;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.GeneratedValue;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Random;

@Data
@Document
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Client {
    private static final Random r = new Random();
    @Id
    @GeneratedValue
    private String id;
    @Indexed
    private String name;
    private String email;


    public static Client random() {
        return builder()
                .name(GenerateData.randomPersonName())
                .email(GenerateData.randomEmail())
                .build();
    }
}
