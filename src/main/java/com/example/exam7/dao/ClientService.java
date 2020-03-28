package com.example.exam7.dao;

import com.example.exam7.dto.ClientDTO;
import com.example.exam7.exception.ResourceNotFoundException;
import com.example.exam7.model.Client;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public ClientDTO addClient(ClientDTO clientDTO) {
        var client = Client.builder()
                .name(clientDTO.getName())
                .email(clientDTO.getEmail())
                .build();

        clientRepository.save(client);
        return ClientDTO.from(client);
    }

    public Slice<ClientDTO> findClients(Pageable pageable) {
        var slice = clientRepository.findAll(pageable);
        return slice.map(ClientDTO::from);
    }
    public ClientDTO findOne(String clientId) {
        var movie = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find movie with the ID: " + clientId));
        return ClientDTO.from(movie);
    }
}
