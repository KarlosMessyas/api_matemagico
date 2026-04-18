package br.com.matemagico.service;

import br.com.matemagico.controller.response.DashboardResponseDTO;
import br.com.matemagico.domain.StudentProfile;
import br.com.matemagico.domain.User;
import br.com.matemagico.exception.NotFoundException;
import br.com.matemagico.exception.ProfileAlreadyExistsException;
import br.com.matemagico.repository.StudentProfileRepository;
import br.com.matemagico.repository.UserRepository;
import br.com.matemagico.mapper.StudentProfileMapper;
import br.com.matemagico.controller.request.StudentProfileRequestDTO;
import br.com.matemagico.controller.response.StudentProfileResponseDTO;
import org.springframework.stereotype.Service;
import br.com.matemagico.repository.ProgressRepository;
import br.com.matemagico.domain.Progress;
import java.util.List;

@Service
public class StudentProfileService {

    private final StudentProfileRepository repository;
    private final UserRepository userRepository;
    private final ProgressRepository progressRepository;

    public StudentProfileService(StudentProfileRepository repository, UserRepository userRepository, ProgressRepository progressRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.progressRepository = progressRepository;
    }

    public StudentProfileResponseDTO create(StudentProfileRequestDTO dto) {

        if (repository.existsByUserId(dto.getUserId())) {
            throw new ProfileAlreadyExistsException("Este usuário já possui um perfil de estudante vinculado.");
        }

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));

        StudentProfile profile = StudentProfileMapper.toEntity(dto, user);
        StudentProfile saved = repository.save(profile);

        return StudentProfileMapper.toResponse(saved);
    }

    public DashboardResponseDTO getDashboard(Long studentId) {

        List<Progress> progressList = progressRepository.findByStudentId(studentId);

        long totalActivities = progressList.size();

        int correct = progressList.stream()
                .mapToInt(Progress::getCorrectAnswers)
                .sum();

        int wrong = progressList.stream()
                .mapToInt(Progress::getWrongAnswers)
                .sum();

        double average = progressList.stream()
                .mapToInt(Progress::getScore)
                .average()
                .orElse(0.0);

        return new DashboardResponseDTO(totalActivities, correct, wrong, average);
    }
}