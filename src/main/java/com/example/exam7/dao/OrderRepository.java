package com.example.exam7.dao;

import com.example.exam7.model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Orders,String> {
}
