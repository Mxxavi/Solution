package com.mx.gritsolutions.controller;

import com.mx.gritsolutions.entities.Order;
import com.mx.gritsolutions.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestParam Long userId, @RequestParam Long itemId, @RequestParam int quantity) {
        return orderService.createOrder(userId,quantity,itemId);
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.listOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }
}
