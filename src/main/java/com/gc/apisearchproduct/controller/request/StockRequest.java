package com.gc.apisearchproduct.controller.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockRequest {
    private Long productId;
}
