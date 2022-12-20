package com.gc.apisearchproduct.repository;

import com.gc.apisearchproduct.controller.response.StockResponse;
import com.gc.apisearchproduct.restTemplate.StockRestTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StockRepository {
    private final StockRestTemplate stockRestTemplate;

    public StockRepository(StockRestTemplate stockRestTemplate) {
        this.stockRestTemplate = stockRestTemplate;
    }

    public StockResponse getStockByProductId(Long productId) {
        return stockRestTemplate.getStockByProductId(productId);
    }
}
