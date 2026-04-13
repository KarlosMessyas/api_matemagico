package br.com.matemagico.service;

import br.com.matemagico.controller.request.UserRequestDTO;
import br.com.matemagico.controller.response.UserResponseDTO;
import br.com.matemagico.domain.User;
import br.com.matemagico.mapper.UserMapper;
import br.com.matemagico.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO create(UserRequestDTO userRequestDTO) {
        User user = UserMapper.toEntity(userRequestDTO);
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
