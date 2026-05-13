package br.com.matemagico.controller;

import br.com.matemagico.controller.request.ActivityRequestDTO;
import br.com.matemagico.controller.response.ActivityResponseDTO;
import br.com.matemagico.service.ActivityService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ActivityResponseDTO> create(@Valid @RequestBody ActivityRequestDTO dto) {
        ActivityResponseDTO response = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ActivityResponseDTO>> getActivitiesForStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.findActivitiesForStudent(studentId));
    }
}