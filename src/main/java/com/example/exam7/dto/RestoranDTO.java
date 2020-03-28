package com.example.exam7.dto;

import com.example.exam7.model.Client;
import com.example.exam7.model.Food;
import com.example.exam7.model.Restoran;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class RestoranDTO {
    String id;
    String name;
    String description;
    List<Food> foods;

    public static RestoranDTO from(Restoran restoran) {
        return builder()
                .id(restoran.getId())
                .name(restoran.getName())
                .foods(restoran.getFoods())
                .description(restoran.getDescription())
                .build();
    }

}
