package com.mx.gritsolutions.repositories;

import com.mx.gritsolutions.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository  extends JpaRepository<Item,Long> {
    Optional<Item> findByCode(String code);
}
