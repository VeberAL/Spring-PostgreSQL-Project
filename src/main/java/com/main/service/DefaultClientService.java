package com.main.service;

import com.main.dao.ClientEntity;
import com.main.dao.ClientRepository;
import com.main.exceptions.LoginException;
import com.main.exceptions.RegistrationException;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.util.Optional;

//Реализация интерфейса ClientService
@Service
@RequiredArgsConstructor
public class DefaultClientService implements ClientService {
    private final ClientRepository userRepository;
//Регистрация
    @Override
    public void register(String clientId, String clientSecret) {
        if (userRepository.findById(clientId).isPresent())
            throw new RegistrationException("Client with id: " + clientId + " already registered");
//Генерация salt и вычисление хэш с последующим сохранением
        String hash = BCrypt.hashpw(clientSecret, BCrypt.gensalt());
        userRepository.save(new ClientEntity(clientId, hash));
    }

//Авторизация
    @Override
    public void checkCredentials(String clientId, String clientSecret) {
        Optional<ClientEntity> optionalUserEntity = userRepository.findById(clientId);
        if (optionalUserEntity.isEmpty())
            throw new LoginException("Client with id: " + clientId + " not found");
//Считывание
        ClientEntity clientEntity = optionalUserEntity.get();

        if (!BCrypt.checkpw(clientSecret, clientEntity.getHash()))
            throw new LoginException("Secret is incorrect");
    }
}
