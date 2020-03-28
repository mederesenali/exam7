package com.example.exam7.controller;

import com.example.exam7.annotations.ApiPageable;
import com.example.exam7.dao.ClientService;
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
public class ClientController {
    @Autowired
    ClientService clientService;

    @ApiPageable
    @GetMapping
    public Slice<ClientDTO> findClients(@ApiIgnore Pageable pageable){
        return clientService.findClients(pageable);
    }
    @GetMapping("/{clientId}")
    public ClientDTO getClient(@PathVariable String clientId) {
        return clientService.findOne(clientId);
    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClientDTO addClient(@RequestBody ClientDTO clientDTO) {
        return clientService.addClient(clientDTO);
    }

}
