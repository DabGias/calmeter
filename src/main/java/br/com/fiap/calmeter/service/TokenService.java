package br.com.fiap.calmeter.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.fiap.calmeter.models.Credencial;
import br.com.fiap.calmeter.models.TokenJwt;

@Service
public class TokenService {
    public TokenJwt generateToken(Credencial credencial) {
        return new TokenJwt(String.valueOf(
            JWT.create()
            .withSubject(credencial.email())
            .withIssuer("Calmeter")
            .withExpiresAt(Instant.now().plus(2, ChronoUnit.HOURS))
            .sign(Algorithm.HMAC256("secret"))
        ));
    }

    public String validar(String token) {
        return JWT.require(Algorithm.HMAC256("secret")).withIssuer("Calmeter").build().verify(token).getSubject();
    }
}
