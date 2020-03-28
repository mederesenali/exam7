package com.example.exam7.controller;

import com.example.exam7.annotations.ApiPageable;
import com.example.exam7.dao.FoodRepository;
import com.example.exam7.dao.FoodService;
import com.example.exam7.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
@RestController
@RequestMapping("/")
public class FoodController {
   FoodService foodService;

    @ApiPageable
    @GetMapping
    public Slice<FoodDto> findFoods(@ApiIgnore Pageable pageable){
        return foodService.findFoods(pageable);
    }
    @GetMapping("/{clientId}")
    public FoodDto getFood(@PathVariable String foodId) {
        return foodService.findOne(foodId);
    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public FoodDto addFood(@RequestBody FoodDto foodDto) {
        return foodService.addFood(foodDto);
    }




    }

