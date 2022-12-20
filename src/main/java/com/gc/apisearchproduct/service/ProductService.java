package com.gc.apisearchproduct.service;

import com.gc.apisearchproduct.controller.response.ProductResponse;

public interface ProductService {
    ProductResponse getProduct(Long productId);
}
