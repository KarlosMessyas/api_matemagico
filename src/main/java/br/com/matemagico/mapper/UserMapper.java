package br.com.matemagico.mapper;

import br.com.matemagico.domain.User;
import br.com.matemagico.controller.request.UserRequestDTO;
import br.com.matemagico.controller.response.UserResponseDTO;

public class UserMapper {

    public static User toEntity(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        return user;
    }

    public static UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}