package com.gc.apisearchproduct.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class Product {
    private Long id;
    private String description;

    @NotBlank
    @Size(max = 30)
    private String name;

    @NotBlank
    private Long categoryId;
}
