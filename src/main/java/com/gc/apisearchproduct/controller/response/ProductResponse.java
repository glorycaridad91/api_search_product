package com.gc.apisearchproduct.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Long categoryId;
    private Integer stock;
    private Boolean lastUnits;
}
