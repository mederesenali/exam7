package com.example.exam7.dto;

import com.example.exam7.model.Client;
import com.example.exam7.model.Food;
import com.example.exam7.model.Orders;
import com.example.exam7.model.Restoran;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class OrderDto {
    String id;
    private Client client;
    private Restoran restoran;
    private LocalDateTime orderDate;

    public static OrderDto from(Orders orders) {
        return builder()
                .id(orders.getId())
                .client(orders.getClient())
                .restoran(orders.getRestoran())
                .orderDate(orders.getOrderDate())
                .build();
    }

}
