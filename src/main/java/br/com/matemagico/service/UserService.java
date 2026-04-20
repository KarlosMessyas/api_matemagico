package br.com.matemagico.service;

import br.com.matemagico.controller.request.UserRequestDTO;
import br.com.matemagico.controller.response.UserResponseDTO;
import br.com.matemagico.domain.User;
import br.com.matemagico.exception.EmailAlreadyExistsException;
import br.com.matemagico.mapper.UserMapper;
import br.com.matemagico.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO create(UserRequestDTO userRequestDTO) {

        if (userRepository.existsByEmail(userRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("Email já cadastrado");
        }

        User user = UserMapper.toEntity(userRequestDTO);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User saved = userRepository.save(user);
        return UserMapper.toResponse(saved);
    }

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }
}