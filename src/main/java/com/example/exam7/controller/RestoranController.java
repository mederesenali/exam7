package com.example.exam7.controller;

import com.example.exam7.annotations.ApiPageable;
import com.example.exam7.dao.ClientService;
import com.example.exam7.dao.RestoranService;
import com.example.exam7.dto.ClientDTO;
import com.example.exam7.dto.RestoranDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/")
public class RestoranController {
    @Autowired
    RestoranService restoranService;
    @GetMapping("/{restoranId}")
    public RestoranDTO getRestoran(@PathVariable String restoranId) {
        return restoranService.findOne(restoranId);
    }




    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public RestoranDTO addRestoran(@RequestBody RestoranDTO restoranDTO) {
        return restoranService.addRestoran(restoranDTO);
    }




}
