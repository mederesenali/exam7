package com.example.exam7.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RestoranRepository extends PagingAndSortingRepository<RestoranRepository,String> {
     Iterable<RestoranRepository> findAll(Sort s);

}
