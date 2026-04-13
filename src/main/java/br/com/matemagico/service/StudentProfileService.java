package br.com.matemagico.service;

import br.com.matemagico.domain.StudentProfile;
import br.com.matemagico.domain.User;
import br.com.matemagico.repository.StudentProfileRepository;
import br.com.matemagico.repository.UserRepository;
import br.com.matemagico.mapper.StudentProfileMapper;
import br.com.matemagico.controller.request.StudentProfileRequestDTO;
import br.com.matemagico.controller.response.StudentProfileResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileService {

    private final StudentProfileRepository repository;
    private final UserRepository userRepository;

    public StudentProfileService(StudentProfileRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public StudentProfileResponseDTO create(StudentProfileRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        StudentProfile profile = StudentProfileMapper.toEntity(dto, user);
        StudentProfile saved = repository.save(profile);

        return StudentProfileMapper.toResponse(saved);
    }
}