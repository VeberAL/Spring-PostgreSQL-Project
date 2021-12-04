package com.main.service;

// Сервис для регистрации нового клиента и проверки его
// аутентификационных данных

public interface ClientService {
    void register(String clientId, String clientSecret);
    void checkCredentials(String clientId, String clientSecret);
}
