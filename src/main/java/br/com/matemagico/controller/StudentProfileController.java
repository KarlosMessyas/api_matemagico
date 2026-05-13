package br.com.matemagico.controller;

import br.com.matemagico.controller.request.StudentProfileRequestDTO;
import br.com.matemagico.controller.response.DashboardResponseDTO;
import br.com.matemagico.controller.response.StudentProfileResponseDTO;
import br.com.matemagico.service.StudentProfileService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class StudentProfileController {

    private final StudentProfileService service;

    public StudentProfileController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentProfileResponseDTO> create(@Valid @RequestBody StudentProfileRequestDTO dto) {
        StudentProfileResponseDTO response = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}/dashboard")
    public ResponseEntity<DashboardResponseDTO> dashboard(@PathVariable Long id) {
        DashboardResponseDTO response = service.getDashboard(id);
        return ResponseEntity.ok(response);
    }
}