package br.com.matemagico.service;

import br.com.matemagico.domain.Activity;
import br.com.matemagico.mapper.ActivityMapper;
import br.com.matemagico.repository.ActivityRepository;
import br.com.matemagico.controller.request.ActivityRequestDTO;
import br.com.matemagico.controller.response.ActivityResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository repository;

    public ActivityService(ActivityRepository repository) {
        this.repository = repository;
    }

    public ActivityResponseDTO create(ActivityRequestDTO dto) {
        Activity activity = ActivityMapper.toEntity(dto);
        Activity saved = repository.save(activity);
        return ActivityMapper.toResponse(saved);
    }

    public List<ActivityResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(ActivityMapper::toResponse)
                .toList();
    }
}