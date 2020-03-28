package com.example.exam7.dao;


import com.example.exam7.dto.OrderDto;
;
import com.example.exam7.exception.ResourceNotFoundException;
import com.example.exam7.model.Orders;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;


@Service
public class OderService {
    @Autowired
    OrderRepository orderRepository;

    public  OrderDto addOrder(OrderDto orderDto){
        var order= Orders.builder()
                .client(orderDto.getClient())
                .restoran(orderDto.getRestoran())
                .orderDate(orderDto.getOrderDate())
                .build();
        orderRepository.save(order);
        return OrderDto.from(order);

    }

    public Slice<OrderDto> findOrders(Pageable pageable) {
        var slice = orderRepository.findAll(pageable);
        return slice.map(OrderDto::from);
    }
    public OrderDto findOne(String clientId) {
        var movie = orderRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find movie with the ID: " + clientId));
        return OrderDto.from(movie);
    }


}
