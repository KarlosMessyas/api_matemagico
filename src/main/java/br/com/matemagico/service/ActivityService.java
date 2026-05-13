package br.com.matemagico.service;

import br.com.matemagico.controller.request.AnswerRequestDTO;
import br.com.matemagico.controller.response.AnswerResponseDTO;
import br.com.matemagico.domain.Activity;
import br.com.matemagico.domain.Progress;
import br.com.matemagico.domain.StudentProfile;
import br.com.matemagico.exception.NotFoundException;
import br.com.matemagico.mapper.ActivityMapper;
import br.com.matemagico.repository.ActivityRepository;
import br.com.matemagico.controller.request.ActivityRequestDTO;
import br.com.matemagico.controller.response.ActivityResponseDTO;
import br.com.matemagico.repository.ProgressRepository;
import br.com.matemagico.repository.StudentProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final StudentProfileRepository studentRepository;
    private final ProgressRepository progressRepository;

    public ActivityResponseDTO create(ActivityRequestDTO dto) {
        Activity activity = ActivityMapper.toEntity(dto);
        Activity saved = activityRepository.save(activity);
        return ActivityMapper.toResponse(saved);
    }

    public List<ActivityResponseDTO> findAll() {
        return activityRepository.findAll()
                .stream()
                .map(ActivityMapper::toResponse)
                .toList();
    }

    public List<ActivityResponseDTO> findActivitiesForStudent(Long studentId) {

        StudentProfile student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado!"));

        List<Activity> activities = activityRepository.findByLevel(student.getLevel());

        return activities.stream()
                .map(ActivityMapper::toResponse)
                .toList();
    }
}