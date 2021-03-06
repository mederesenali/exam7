package com.example.exam7.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "restorans")
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Restoran {
    @Id
    @GeneratedValue
    String id;
    String name;
    String description;
    @DBRef
    List<Food> foods=new ArrayList<>();


}


