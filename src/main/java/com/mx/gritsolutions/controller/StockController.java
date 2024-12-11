package com.mx.gritsolutions.controller;

import com.mx.gritsolutions.entities.Item;
import com.mx.gritsolutions.entities.Stock;
import com.mx.gritsolutions.service.ItemService;
import com.mx.gritsolutions.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping
    public Stock createStock(@RequestParam int quantity, @RequestParam Long itemId) {
        return stockService.createStock(quantity,itemId);
    }

    @PostMapping("/changeStock")
    public Stock updateStock(@RequestParam int quantity, @RequestParam Long itemId) {
        return stockService.updateStock(quantity,itemId);
    }

    @GetMapping
    public List<Stock> getAll() {
        return stockService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Stock> getItemById(@PathVariable Long id) {
        return stockService.getById(id);
    }
}
