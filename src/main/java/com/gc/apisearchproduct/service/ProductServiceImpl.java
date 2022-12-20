package com.gc.apisearchproduct.service;

import com.gc.apisearchproduct.controller.response.ProductResponse;
import com.gc.apisearchproduct.domain.Product;
import com.gc.apisearchproduct.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;
    private final StockService stockService;

    //dependency injection by constructor
    public ProductServiceImpl(ProductRepository productRepository, StockService stockService) {
        this.productRepository = productRepository;
        this.stockService = stockService;
    }

    @Override
    public ProductResponse getProduct(Long productId) {
        LOGGER.info("obtaining product by ID");
        Product product =  productRepository.getProductById(productId);
        LOGGER.info("obtaining product in stock by ID");
        Integer stock = stockService.getStock(productId);
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .categoryId(product.getCategoryId())
                .lastUnits(calculateLastUnits(stock))
                .stock(stock)
                .build();
    }

    private Boolean calculateLastUnits(Integer stock) {
        LOGGER.info("less than 20 products left in stock");
        return stock < 20;
    }
}
