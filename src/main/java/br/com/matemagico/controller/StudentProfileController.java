package br.com.matemagico.controller;

import br.com.matemagico.controller.request.StudentProfileRequestDTO;
import br.com.matemagico.controller.response.StudentProfileResponseDTO;
import br.com.matemagico.service.StudentProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping
    public StudentProfileResponseDTO create(@RequestBody StudentProfileRequestDTO dto) {
        return service.create(dto);
    }
}