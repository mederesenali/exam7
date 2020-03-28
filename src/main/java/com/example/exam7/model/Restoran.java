package com.example.exam7.model;

import lombok.*;
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
    List<Food> foods=new ArrayList<>();


}
@Data
class Food {
    @Id
    @GeneratedValue
    private String id;

    private String name;
    private String type;

    private int price;

}


