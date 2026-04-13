package br.com.matemagico.controller;

import br.com.matemagico.controller.request.ActivityRequestDTO;
import br.com.matemagico.controller.response.ActivityResponseDTO;
import br.com.matemagico.service.ActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityService service;

    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @PostMapping
    public ActivityResponseDTO create(@RequestBody ActivityRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<ActivityResponseDTO> findAll() {
        return service.findAll();
    }
}