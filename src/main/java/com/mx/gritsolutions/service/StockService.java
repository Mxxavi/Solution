package com.mx.gritsolutions.service;

import com.mx.gritsolutions.entities.Item;
import com.mx.gritsolutions.entities.Stock;
import com.mx.gritsolutions.repositories.ItemRepository;
import com.mx.gritsolutions.repositories.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    static Logger logger = LoggerFactory.getLogger(StockService.class.getName());

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ItemRepository itemRepository;

    public Stock createStock(int quantity, Long itemId){
        return saveStock(quantity,itemId);
    }

    public Item findItem(Long itemId){
        Optional<Item> itemOptional = itemRepository.findById(itemId);
        if(itemOptional.isEmpty()){
            logger.error("Item not found!");
            throw new RuntimeException("Item not found!");
        }
        return  itemOptional.get();
    }

    public Stock saveStock(int quantity, Long itemId){
        Item item = findItem(itemId);
        Stock stock = stockRepository.findStockByItemId(item.getId());
        if(stock !=null){
            logger.info("Existing stock for that Item! update stock for item {}", item.getName());
            return stockRepository.save(new Stock(String.valueOf(stock.getId()),quantity, LocalDateTime.now(),item));
        }else {
            logger.info("NO stock created for that Item! Created new stock for item {}", item.getName());
            return stockRepository.save(new Stock(null,quantity, LocalDateTime.now(),item));
        }
    }

    public List<Stock> getAll(){
        return stockRepository.findAll();
    }

    public Optional<Stock> getById(Long id){
        return stockRepository.findById(id);
    }
}
