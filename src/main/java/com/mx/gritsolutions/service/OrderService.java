package com.mx.gritsolutions.service;

import com.mx.gritsolutions.entities.*;
import com.mx.gritsolutions.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class OrderService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private OrderRepository orderRepository;

    static Logger logger = LoggerFactory.getLogger(OrderService.class.getName());

    public Order createOrder(Long userId, int quantity, Long itemId) {
        // Verifica se o usuário e o item existem
        Optional<Item> itemOpt = itemRepository.findById(itemId);
        Optional<User> userOpt = userRepository.findById(userId);

        if (itemOpt.isEmpty()) {
            logger.error("Create Order Item '{}' not found.", itemId);
            throw new RuntimeException("Item not found!");
        }
        if (userOpt.isEmpty()) {
            logger.error("Error: Create Order User '{}' not found.", userId);
            throw new RuntimeException("User not found!");
        }

        Item item = itemOpt.get();
        User user = userOpt.get();

        // create new order
        Order order = new Order(quantity,item,user,false);

        // save order
        saveOrder(order);
        return order;
    }

    public void saveOrder(Order order){
        order.setOrderIsCompleted(false);
        orderRepository.save(order);
        verifyUpdateStock(order);
    }

    public void verifyUpdateStock(Order order){
        Stock stockMovement = stockRepository.findStockByItemId(order.getItem().getId());
        int stockQuantity = stockMovement.getQuantity();
        if(stockQuantity >= order.getQuantity()){
            //Save order new status
            order.setOrderIsCompleted(true);
            orderRepository.save(order);
            logger.info("Successfully created order: {}", order);
            //update stock
            stockMovement.setQuantity(stockMovement.getQuantity() - order.getQuantity());
            stockRepository.save(stockMovement);
            logger.info("Successfully updated stock: {}", stockMovement);
            //Send mail
            sendOrderCompletionEmail(order.getUser());
        }else{
            logger.error("Create Order - Insufficient stock to complete the order, stockQuantity:'{}'", stockQuantity);
            throw new RuntimeException("Insufficient stock to complete the order.");
        }
    }

    // Sends an email to notify the user that the order has been completed
    private void sendOrderCompletionEmail(User user) {

        // In this function the placeholder and the notification for the email service will then be written
        logger.info("Mail send to {} about end order.", user.getMail());
    }

    // list all orders
    public List<Order> listOrders() {
        return orderRepository.findAll();
    }

    // find order by ID
    public Optional<Order> getOrder(Long orderId) {
        return orderRepository.findById(orderId);
    }

}
