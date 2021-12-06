package com.main.model;
import lombok.Value;

//Ответ в случае ошибки
@Value
public class ErrorResponse {
    String message;
}