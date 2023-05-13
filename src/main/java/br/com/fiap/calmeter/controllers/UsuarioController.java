package br.com.fiap.calmeter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fiap.calmeter.models.Credencial;
import br.com.fiap.calmeter.models.Usuario;
import br.com.fiap.calmeter.repositories.UsuarioRepository;
import br.com.fiap.calmeter.service.TokenService;
import jakarta.validation.Valid;

public class UsuarioController {
    @Autowired
    UsuarioRepository repo;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    TokenService tokenService;

    @PostMapping("/calmeter/registrar")
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario u) {
        u.setSenha(encoder.encode(u.getSenha()));
        repo.save(u);

        return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }

    @PostMapping("/calmeter/login")
    public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial) {
        manager.authenticate(credencial.toAuthentication());
        var token = tokenService.generateToken(credencial);

        return ResponseEntity.ok(token);
    }
}
