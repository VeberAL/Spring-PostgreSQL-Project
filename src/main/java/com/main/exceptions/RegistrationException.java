package com.main.exceptions;
public class RegistrationException extends RuntimeException {
//Исключение для авторизации
    public RegistrationException(String message) {
        super(message);
    }
}