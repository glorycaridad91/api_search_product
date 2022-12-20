package com.gc.apisearchproduct.exception.exceptionHandler;

import com.gc.apisearchproduct.exception.ProductOutOfStockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalAdviceHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalAdviceHandler.class);

    @ExceptionHandler(value = {ProductOutOfStockException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> handleProductOutOfStockException(ProductOutOfStockException productOutOfStockException) {
        Map<String, String> statusMap = new HashMap<>();
        statusMap.put("message", productOutOfStockException.getMessage());
        LOGGER.error(productOutOfStockException.getMessage());
        return new ResponseEntity<>(statusMap, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, String>> handleException(Exception exception) {
        Map<String, String> statusMap = new HashMap<>();
        statusMap.put("message", exception.getMessage());
        LOGGER.error(exception.getMessage());
        return new ResponseEntity<>(statusMap, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
