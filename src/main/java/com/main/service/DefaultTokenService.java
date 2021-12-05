package com.main.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

//Реализация интерфейса формирования токена Json web token
@Service
public class DefaultTokenService implements TokenService {
    @Value("${auth.jwt.secret}")
    private String secretKey;

    @Override
    public String generateToken(String clientId) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        Instant now = Instant.now();
        Instant exp = now.plus(5, ChronoUnit.MINUTES);

        return JWT.create()
                .withIssuer("auth-service") //издатель токена
                .withAudience("bookstore")  //сервис, для которого предназначен токен
                .withSubject(clientId)      //идентификатор клиента
                .withIssuedAt(Date.from(now))  //текущее время (для формирования токена)
                .withExpiresAt(Date.from(exp)) //время до окончания действия токена (минут 5)
                .sign(algorithm);
    }
}
