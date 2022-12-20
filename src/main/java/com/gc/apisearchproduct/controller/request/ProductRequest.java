package com.gc.apisearchproduct.controller.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {
    private Long categoryId;
    private Long idProduct;
}
