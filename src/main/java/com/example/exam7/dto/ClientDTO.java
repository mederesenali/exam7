package com.example.exam7.dto;

import com.example.exam7.model.Client;
import lombok.*;

import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class ClientDTO {
    private String id;
    private String name;
    private String email;


    public static ClientDTO from(Client client) {
        return builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .build();
    }
}
