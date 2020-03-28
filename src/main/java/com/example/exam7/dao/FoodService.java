package com.example.exam7.dao;

import com.example.exam7.dto.FoodDto;
import com.example.exam7.exception.ResourceNotFoundException;
import com.example.exam7.model.Food;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    @Autowired
    FoodRepository foodRepository;

    public FoodDto addFood(FoodDto foodDto) {
        var food = Food.builder()
                .name(foodDto.getName())
                .type(foodDto.getType())
                .price(foodDto.getPrice())
                .build();

        foodRepository.save(food);
        return FoodDto.from(food);
    }

    public Slice<FoodDto> findFoods(Pageable pageable) {
        var slice = foodRepository.findAll(pageable);
        return slice.map(FoodDto::from);
    }
    public FoodDto findOne(String clientId) {
        var movie = foodRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find movie with the ID: " + clientId));
        return FoodDto.from(movie);
    }



}
