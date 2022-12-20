package com.gc.apisearchproduct.service;

import com.gc.apisearchproduct.exception.ProductOutOfStockException;
import com.gc.apisearchproduct.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService{

    private static final Logger LOGGER = LoggerFactory.getLogger(StockServiceImpl.class);
    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Integer getStock(Long productId) {
        LOGGER.info("Getting product in stock by ID");
        int stock = stockRepository.getStockByProductId(productId).getQuantity();
        if(stock < 1) {
            throw  new ProductOutOfStockException("The ProductId: " + productId + " is out of stock");
        }
        return stock;
    }
}
