package com.mx.gritsolutions.repositories;

import com.mx.gritsolutions.entities.Item;
import com.mx.gritsolutions.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
