package br.com.matemagico.controller;

import br.com.matemagico.controller.request.UserRequestDTO;
import br.com.matemagico.controller.response.ApiResponse;
import br.com.matemagico.controller.response.UserResponseDTO;
import br.com.matemagico.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse<UserResponseDTO> create(@RequestBody @Valid UserRequestDTO dto) {
        UserResponseDTO user = service.create(dto);
        return new ApiResponse<>(user, "User created successfully");
    }

    @GetMapping
    public List<UserResponseDTO> findAll() {
        return service.findAll();
    }
}