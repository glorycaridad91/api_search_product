package com.gc.apisearchproduct.restTemplate;

import com.gc.apisearchproduct.controller.request.StockRequest;
import com.gc.apisearchproduct.controller.response.StockResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StockRestTemplate {
    private final RestTemplate restTemplate;

    public StockRestTemplate(RestTemplateBuilder builder) {
        restTemplate = builder
                .rootUri("http://localhost:9083/api/api-stock-service/v1")
                .build();
    }
    public StockResponse getStockByProductId(Long productId) {
        StockRequest.builder().build().setProductId(productId);
        return restTemplate.getForObject("/stock/{productId}",
                StockResponse.class, productId);
    }
}
