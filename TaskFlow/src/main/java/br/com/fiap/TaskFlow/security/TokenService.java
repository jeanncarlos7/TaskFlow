package br.com.fiap.TaskFlow.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.fiap.TaskFlow.model.User;
import br.com.fiap.TaskFlow.repository.UserRepository;

@Service
public class TokenService {

    private final UserRepository userRepository;
    Algorithm algorithm;

    public TokenService(UserRepository userRepository, @Value("${jwt.secret}") String secret) {
        algorithm = Algorithm.HMAC256(secret);
        this.userRepository = userRepository;
    }

    public Token createToken(String email) {

        String token = JWT.create()
                .withSubject(email)
                .withIssuer("nextgen")
                .sign(algorithm);

        return new Token(token, "JWT");
    }

    public User getUserByToken(String token) {
        var email = JWT.require(algorithm)
                .build()
                .verify(token)
                .getSubject();

        return userRepository.findByUsername(email);
    }
}
