package com.mx.gritsolutions.controller;

import com.mx.gritsolutions.entities.Item;
import com.mx.gritsolutions.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public Item createItem(@RequestParam String name,@RequestParam String code) {
        return itemService.createItem(name,code);
    }

    @GetMapping
    public List<Item> getAll() {
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }
}
