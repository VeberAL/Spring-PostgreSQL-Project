package com.main.model;

import lombok.Value;
//Аутентификационные данные пользователя
@Value
public class User {
    String clientId;
    String clientSecret;
}
