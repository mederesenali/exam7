package com.example.exam7.controller;

import com.example.exam7.annotations.ApiPageable;
import com.example.exam7.dao.OderService;
import com.example.exam7.dao.OrderRepository;
import com.example.exam7.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/")
public class OrderController {
    @Autowired
    OderService orderService;
    @ApiPageable
    @GetMapping
    public Slice<OrderDto> findOrders(@ApiIgnore Pageable pageable){
        return orderService.findOrders(pageable);
    }
    @GetMapping("/{orderId}")
    public OrderDto getOrder(@PathVariable String orderId) {
        return orderService.findOne(orderId);
    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto addClient(@RequestBody OrderDto orderDto) {
        return orderService.addOrder(orderDto);
    }
}
