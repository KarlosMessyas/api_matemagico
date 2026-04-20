package br.com.matemagico.controller;

import br.com.matemagico.controller.request.LoginRequest;
import br.com.matemagico.domain.User;
import br.com.matemagico.exception.InvalidCredentialsException;
import br.com.matemagico.repository.UserRepository;
import br.com.matemagico.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {

        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new InvalidCredentialsException("Email ou senha inválidos"));

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new InvalidCredentialsException("Email ou senha inválidos");
        }

        return jwtService.generateToken(user.getEmail());
    }
}
