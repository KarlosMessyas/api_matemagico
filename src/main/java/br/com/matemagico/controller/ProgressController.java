package br.com.matemagico.controller;

import br.com.matemagico.controller.request.ProgressRequestDTO;
import br.com.matemagico.controller.response.ProgressResponseDTO;
import br.com.matemagico.service.ProgressService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/progress")
public class ProgressController {

    private final ProgressService service;

    public ProgressController(ProgressService service) {
        this.service = service;
    }

    @PostMapping
    public ProgressResponseDTO create(@RequestBody ProgressRequestDTO dto) {
        return service.create(dto);
    }
}