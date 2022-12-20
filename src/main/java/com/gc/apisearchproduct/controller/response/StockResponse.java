package com.gc.apisearchproduct.controller.response;

import lombok.Data;

@Data
public class StockResponse {
    private Long id;
    private Long productId;
    private int quantity;
    private boolean flag;
}
