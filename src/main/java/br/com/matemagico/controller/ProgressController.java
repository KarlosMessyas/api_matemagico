package br.com.matemagico.controller;

import br.com.matemagico.controller.request.AnswerRequestDTO;
import br.com.matemagico.controller.response.ProgressResponseDTO;
import br.com.matemagico.service.ProgressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/progress")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @PostMapping("/answer")
    public ResponseEntity<ProgressResponseDTO> submitAnswer(@Valid @RequestBody AnswerRequestDTO request) {
        ProgressResponseDTO response = progressService.processAnswer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}