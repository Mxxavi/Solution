package com.mx.gritsolutions.repositories;

import com.mx.gritsolutions.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {

    /**
     * @param idItem
     * @return Stock
     */
    Stock findStockByItemId (Long idItem);
}
