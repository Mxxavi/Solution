package com.mx.gritsolutions.service;

import com.mx.gritsolutions.entities.Item;
import com.mx.gritsolutions.entities.Stock;
import com.mx.gritsolutions.repositories.ItemRepository;
import com.mx.gritsolutions.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Stock createStock(int quantity, Long itemId){
        Optional<Item> itemOptional = itemRepository.findById(itemId);
        if(itemOptional.isEmpty()){
            throw new RuntimeException("Item not found!");
        }
        Stock stock = stockRepository.findStockByItemId(itemId);
        if(stock !=null){
            throw new RuntimeException("There is already a stock created for that Item!");
        }

        return stockRepository.save(new Stock(quantity, LocalDateTime.now(),itemOptional.get()));
    }

    public Stock updateStock(int quantity, Long itemId){
        Optional<Item> itemOptional = itemRepository.findById(itemId);
        if(itemOptional.isEmpty()){
            throw new RuntimeException("Item not found!");
        }
        Stock stock = stockRepository.findStockByItemId(itemId);
        if(stock !=null){
            return stockRepository.save(new Stock(stock.getId(),quantity, LocalDateTime.now(),itemOptional.get()));
        }else {
            throw new RuntimeException("NO stock created for that Item!");
        }

    }

    public List<Stock> getAll(){
        return stockRepository.findAll();
    }

    public Optional<Stock> getById(Long id){
        return stockRepository.findById(id);
    }
}
