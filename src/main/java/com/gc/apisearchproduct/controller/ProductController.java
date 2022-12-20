package com.gc.apisearchproduct.controller;

import com.gc.apisearchproduct.controller.response.ProductResponse;
import com.gc.apisearchproduct.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/api-search-product/v1")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    //dependency injection by constructor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Get a product by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the product",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content) })
    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductResponse> getProductById(
            @Parameter(description = "id of product to be searched")
            @PathVariable(value = "productId") Long productId) {
        LOGGER.info("Getting product by the ID: " + productId);
        return new ResponseEntity<>(productService.getProduct(productId), HttpStatus.OK);
    }
}
