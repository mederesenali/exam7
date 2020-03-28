package com.example.exam7.dao;

import com.example.exam7.model.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FoodRepository extends PagingAndSortingRepository<Food,String> {
}
