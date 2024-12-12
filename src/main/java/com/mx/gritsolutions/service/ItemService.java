package com.mx.gritsolutions.service;

import com.mx.gritsolutions.entities.Item;
import com.mx.gritsolutions.repositories.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    static Logger logger = LoggerFactory.getLogger(ItemService.class.getName());

    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(String name,String code){
        Optional<Item> existingItem = itemRepository.findByCode(code);
        if (existingItem.isPresent()) {
            logger.error("Item with code {} already exists.", code);
            throw new RuntimeException("Item with code " + code + " already exists.");
        }
        return itemRepository.save(new Item(name,code));
    }

    public List<Item> getAll(){
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(Long id){
        return itemRepository.findById(id);
    }

}
