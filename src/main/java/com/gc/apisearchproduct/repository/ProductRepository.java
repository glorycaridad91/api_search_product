package com.gc.apisearchproduct.repository;

import com.gc.apisearchproduct.domain.Product;
import com.gc.apisearchproduct.restTemplate.ProductRestTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    private final ProductRestTemplate productRestTemplate;

    //dependency injection by constructor
    public ProductRepository(ProductRestTemplate productRestTemplate) {
        this.productRestTemplate = productRestTemplate;
    }

    public Product getProductById(Long productId) {
        return productRestTemplate.getProductById(productId);
    }
}
