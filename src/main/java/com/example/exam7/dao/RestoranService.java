package com.example.exam7.dao;

import com.example.exam7.dto.OrderDto;
import com.example.exam7.dto.RestoranDTO;
import com.example.exam7.exception.ResourceNotFoundException;
import com.example.exam7.model.Restoran;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class RestoranService {
    @Autowired
    RestoranRepository restoranRepository;

    public RestoranDTO addRestoran(RestoranDTO restoranDTO) {
        var foodCord = Restoran.builder()
                .name(restoranDTO.getName())
                .description(restoranDTO.getDescription())
                .foods(restoranDTO.getFoods())
                .build();


        return RestoranDTO.from(foodCord);
    }

   
    public RestoranDTO findOne(String restoranId) {
        var restoran = restoranRepository.findById(restoranId)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find movie with the ID: " + restoranId));
        return RestoranDTO.from((Restoran) restoran);
    }
}
