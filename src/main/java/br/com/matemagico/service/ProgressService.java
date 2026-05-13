package br.com.matemagico.service;

import br.com.matemagico.controller.request.AnswerRequestDTO;
import br.com.matemagico.controller.response.ProgressResponseDTO;
import br.com.matemagico.domain.Activity;
import br.com.matemagico.domain.Progress;
import br.com.matemagico.domain.StudentProfile;
import br.com.matemagico.exception.NotFoundException;
import br.com.matemagico.mapper.ProgressMapper;
import br.com.matemagico.repository.ActivityRepository;
import br.com.matemagico.repository.ProgressRepository;
import br.com.matemagico.repository.StudentProfileRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProgressService {

    private final ProgressRepository repository;
    private final StudentProfileRepository studentRepository;
    private final ActivityRepository activityRepository;
    private final ObjectMapper objectMapper;

    public ProgressService(
            ProgressRepository repository,
            StudentProfileRepository studentRepository,
            ActivityRepository activityRepository
    ) {
        this.repository = repository;
        this.studentRepository = studentRepository;
        this.activityRepository = activityRepository;
        this.objectMapper = new ObjectMapper();
    }

    public ProgressResponseDTO processAnswer(AnswerRequestDTO dto) {

        StudentProfile student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado!"));

        Activity activity = activityRepository.findById(dto.getActivityId())
                .orElseThrow(() -> new NotFoundException("Atividade não encontrada!"));

        boolean isCorrect = validateAnswer(activity, dto.getAnswer());

        Progress progress = new Progress();
        progress.setStudent(student);
        progress.setActivity(activity);

        int timeSpent = dto.getTimeSpentInSeconds() != null ? dto.getTimeSpentInSeconds() : 0;
        progress.setTimeSpentInSeconds(timeSpent);
        progress.setCompletionDate(LocalDateTime.now());

        if (isCorrect) {
            progress.setCorrectAnswers(1);
            progress.setWrongAnswers(0);
            progress.setScore(calculateScore(timeSpent));
        } else {
            progress.setCorrectAnswers(0);
            progress.setWrongAnswers(1);
            progress.setScore(0);
        }

        Progress saved = repository.save(progress);

        return ProgressMapper.toResponse(saved);
    }

    private boolean validateAnswer(Activity activity, String studentAnswer) {
        try {
            JsonNode json = objectMapper.readTree(activity.getContent());

            String correctAnswer = json.has("answer") ? json.get("answer").asText() : json.get("correctAnswer").asText();

            return studentAnswer != null && studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim());

        } catch (Exception e) {
            System.err.println("Erro ao validar o JSON da atividade: " + e.getMessage());
            return false;
        }
    }

    private Integer calculateScore(Integer timeSpentInSeconds) {
        if (timeSpentInSeconds <= 15) return 3;
        if (timeSpentInSeconds <= 30) return 2;
        return 1;
    }
}