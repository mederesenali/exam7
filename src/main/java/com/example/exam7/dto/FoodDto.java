package com.example.exam7.dto;


import com.example.exam7.model.Food;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class FoodDto {
    private String id;

    private String name;
    private String type;

    private int price;

    public static FoodDto from(Food foodDto){
        return builder().
                id(foodDto.getId())
                .name(foodDto.getName())
                .type(foodDto.getType())
                .price(foodDto.getPrice())
                .build();
    }
}
