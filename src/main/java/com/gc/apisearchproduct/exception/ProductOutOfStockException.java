package com.gc.apisearchproduct.exception;

public class ProductOutOfStockException extends RuntimeException {
    public ProductOutOfStockException(String msg) {
        super(msg);
    }
}
