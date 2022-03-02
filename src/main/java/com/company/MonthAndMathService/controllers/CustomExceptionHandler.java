package com.company.MonthAndMathService.controllers;

import com.company.MonthAndMathService.models.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<CustomErrorResponse> invalidOperand(HttpMessageNotReadableException e) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), e.getMessage());
        errorResponse.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        errorResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorResponse> nullOperand(NullPointerException e) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), e.getMessage());
        errorResponse.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        errorResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CustomErrorResponse> nullOperand(IllegalArgumentException e) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.toString(), e.getMessage());
        errorResponse.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        errorResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
