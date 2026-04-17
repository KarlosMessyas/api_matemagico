package br.com.matemagico.service;

import br.com.matemagico.domain.Activity;
import br.com.matemagico.domain.Progress;
import br.com.matemagico.domain.StudentProfile;
import br.com.matemagico.exception.NotFoundException;
import br.com.matemagico.repository.ActivityRepository;
import br.com.matemagico.repository.ProgressRepository;
import br.com.matemagico.repository.StudentProfileRepository;
import br.com.matemagico.mapper.ProgressMapper;
import br.com.matemagico.controller.request.ProgressRequestDTO;
import br.com.matemagico.controller.response.ProgressResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class ProgressService {

    private final ProgressRepository repository;
    private final StudentProfileRepository studentRepository;
    private final ActivityRepository activityRepository;

    public ProgressService(
            ProgressRepository repository,
            StudentProfileRepository studentRepository,
            ActivityRepository activityRepository
    ) {
        this.repository = repository;
        this.studentRepository = studentRepository;
        this.activityRepository = activityRepository;
    }

    public ProgressResponseDTO create(ProgressRequestDTO dto) {

        StudentProfile student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado!"));

        Activity activity = activityRepository.findById(dto.getActivityId())
                .orElseThrow(() -> new NotFoundException("Atividade não encontrada!"));

        Progress progress = ProgressMapper.toEntity(dto, student, activity);
        Progress saved = repository.save(progress);

        return ProgressMapper.toResponse(saved);
    }
}