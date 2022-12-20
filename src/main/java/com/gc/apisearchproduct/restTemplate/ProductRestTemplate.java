package com.gc.apisearchproduct.restTemplate;

import com.gc.apisearchproduct.controller.request.ProductRequest;
import com.gc.apisearchproduct.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductRestTemplate {
    private final RestTemplate restTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestTemplate.class);

    public ProductRestTemplate(RestTemplateBuilder builder) {
        this.restTemplate = builder
                .rootUri("http://localhost:9082/api/api-product-service/v1")
                .build();
    }


    public Product getProductById(Long productId) {
        ProductRequest.builder().build().setIdProduct(productId);
        LOGGER.info("GetForObject restTemplate by product ID: " + productId);
        return restTemplate.getForObject("/product/{productId}",
                Product.class, productId);
    }
}
